# Modifies a daemontools-based package to run as a non-root user.

DAEMONTOOLS_RUN := "setuidgid ${RUN_AS} ${DAEMONTOOLS_RUN}"

pkg_postinst_${PN}() {
    if test -z "$D"; then
      /usr/sbin/adduser --system --home / --no-create-home --ingroup dialout ${RUN_AS} || :
    fi
}

do_install_append () {
	sed -i 's|<policy user="root">|<policy user="${RUN_AS}">|g' ${D}/${sysconfdir}/dbus-1/system.d/${DBUS_STUB}.conf
}
