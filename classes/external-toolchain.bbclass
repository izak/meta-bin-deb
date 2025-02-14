# This class provides everything necessary for a recipe to pull bits from an
# external toolchain:
# - Automatically sets LIC_FILES_CHKSUM based on LICENSE if appropriate
# - Searches the external toolchain sysroot and alternate locations for the
#   patterns specified in the FILES variables, with support for checking
#   alternate locations within the sysroot as well
# - Automatically PROVIDES/RPROVIDES the non-external-suffixed names
# - Usual bits to handle packaging of existing binaries
# - Automatically skips the recipe if its files aren't available in the
#   external toolchain
# - Automatically grabs all the .debug files for everything included

# Since these are prebuilt binaries, there are no source files to checksum for
# LIC_FILES_CHKSUM, so use the license from common-licenses
inherit common-license

# We don't extract anything which will create S, and we don't want to see the
# warning about it
S = "${WORKDIR}"

# Prebuilt binaries, no need for any default dependencies
INHIBIT_DEFAULT_DEPS = "1"

EXTERNAL_PN ?= "${@PN.replace('-external', '')}"
PROVIDES += "${EXTERNAL_PN}"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "${COMMON_LIC_CHKSUM}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

EXTERNAL_PV_PREFIX ?= ""
EXTERNAL_PV_SUFFIX ?= ""
PV_prepend = "${@'${EXTERNAL_PV_PREFIX}' if '${EXTERNAL_PV_PREFIX}' else ''}"
PV_append = "${@'${EXTERNAL_PV_SUFFIX}' if '${EXTERNAL_PV_SUFFIX}' else ''}"

EXTERNAL_EXTRA_FILES ?= ""

# Skip this recipe if we don't have files in the external toolchain
EXTERNAL_AUTO_PROVIDE ?= "0"
EXTERNAL_AUTO_PROVIDE[type] = "boolean"
EXTERNAL_AUTO_PROVIDE_class-target ?= "1"

# We don't care if this path references other variables
EXTERNAL_TOOLCHAIN[vardepvalue] = "${EXTERNAL_TOOLCHAIN}"

# We don't want to rebuild if the path to the toolchain changes, only if the
# toolchain changes
external_toolchain_do_install[vardepsexclude] += "EXTERNAL_TOOLCHAIN"
EXTERNAL_INSTALL_SOURCE_PATHS[vardepsexclude] += "EXTERNAL_TOOLCHAIN"

python () {
    # Skipping only matters up front
    if d.getVar('BB_WORKERCONTEXT', True) == '1':
        return

    # We're not an available provider if there's no external toolchain
    if not d.getVar("EXTERNAL_TOOLCHAIN"):
        raise bb.parse.SkipPackage("External toolchain not configured (EXTERNAL_TOOLCHAIN not set).")

    if not oe.data.typed_value('EXTERNAL_AUTO_PROVIDE', d):
        return

    sysroots, mirrors = oe.external.get_file_search_metadata(d)
    pattern = d.getVar('EXTERNAL_PROVIDE_PATTERN', True)
    if pattern is None:
        files = list(oe.external.gather_pkg_files(d))
        files = filter(lambda f: '.debug' not in f, files)
        expanded = oe.external.expand_paths(files, mirrors)
        paths = oe.external.search_sysroots(expanded, sysroots)
        if not any(f for p, f in paths):
            raise bb.parse.SkipPackage('No files found in external toolchain sysroot for `{}`'.format(', '.join(files)))
    elif not pattern:
        return
    else:
        expanded = oe.external.expand_paths([pattern], mirrors)
        paths = oe.external.search_sysroots(expanded, sysroots)
        if not any(f for p, f in paths):
            raise bb.parse.SkipPackage('No files found in external toolchain sysroot for `{}`'.format(pattern))
}

python do_install () {
    bb.build.exec_func('external_toolchain_do_install', d)
    if 'do_install_extra' in d:
        bb.build.exec_func('do_install_extra', d)
}

python external_toolchain_do_install () {
    import subprocess
    installdest = d.getVar('D', True)
    sysroots, mirrors = oe.external.get_file_search_metadata(d)
    files = oe.external.gather_pkg_files(d)
    oe.external.copy_from_sysroots(files, sysroots, mirrors, installdest)
    subprocess.check_call(['chown', '-R', 'root:root', installdest])
}
external_toolchain_do_install[vardeps] += "${@' '.join('FILES_%s' % pkg for pkg in '${PACKAGES}'.split())}"

# Change do_install's CWD to EXTERNAL_TOOLCHAIN for convenience
do_install[dirs] = "${D} ${EXTERNAL_TOOLCHAIN}"

# Debug files are likely already split out
INHIBIT_PACKAGE_STRIP = "1"

# Toolchain shipped binaries weren't necessarily built ideally
WARN_QA_remove = "ldflags textrel"
ERROR_QA_remove = "ldflags textrel"

RPROVIDES_${PN} += "${EXTERNAL_PN}"
RPROVIDES_${PN}-dev += "${EXTERNAL_PN}-dev"
RPROVIDES_${PN}-staticdev += "${EXTERNAL_PN}-staticdev"
RPROVIDES_${PN}-dbg += "${EXTERNAL_PN}-dbg"
RPROVIDES_${PN}-doc += "${EXTERNAL_PN}-doc"
RPROVIDES_${PN}-locale += "${EXTERNAL_PN}-locale"
LOCALEBASEPN = "${EXTERNAL_PN}"

FILES_${PN} = ""
FILES_${PN}-dev = ""
FILES_${PN}-staticdev = ""
FILES_${PN}-doc = ""
FILES_${PN}-locale = ""

def debug_paths(d):
    l = d.createCopy()
    l.finalize()
    paths = []
    exclude = [
        l.getVar('datadir', True),
        l.getVar('includedir', True),
    ]
    for p in l.getVar('PACKAGES', True).split():
        if p.endswith('-dbg'):
            continue
        for f in (l.getVar('FILES_%s' % p, True) or '').split():
            if any((f == x or f.startswith(x + '/')) for x in exclude):
                continue
            d = os.path.dirname(f)
            b = os.path.basename(f)
            paths.append('/usr/lib/debug{0}/{1}.debug'.format(d, b))
            paths.append('{0}/.debug/{1}'.format(d, b))
            paths.append('{0}/.debug/{1}.debug'.format(d, b))
    return set(paths)

FILES_${PN}-dbg = "${@' '.join(debug_paths(d))}"

