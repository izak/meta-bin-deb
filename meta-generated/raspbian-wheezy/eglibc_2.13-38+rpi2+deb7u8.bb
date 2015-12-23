PACKAGES = "libc-bin libc6-dev libc6 libc-dev-bin"
PROVIDES = "libc-bin libc6-dev libc6 libc-dev-bin"
SRC_URI = " \
	http://archive.raspbian.org/raspbian/pool/main/e/eglibc/libc-bin_2.13-38+rpi2+deb7u8_armhf.deb;unpack=0;name=deb0\
	http://archive.raspbian.org/raspbian/pool/main/e/eglibc/libc6-dev_2.13-38+rpi2+deb7u8_armhf.deb;unpack=0;name=deb1\
	http://archive.raspbian.org/raspbian/pool/main/e/eglibc/libc6_2.13-38+rpi2+deb7u8_armhf.deb;unpack=0;name=deb2\
	http://archive.raspbian.org/raspbian/pool/main/e/eglibc/libc-dev-bin_2.13-38+rpi2+deb7u8_armhf.deb;unpack=0;name=deb3\
"
DEBFILENAME_libc-bin = "libc-bin_2.13-38+rpi2+deb7u8_armhf.deb"
SRC_URI[deb0.sha256sum] = "9d12f77bb324e8b77f343c80dde7f6f3bc5ddf8d37d375baf8d203cebfcfe9ed"
SRC_URI[deb0.md5sum] = "82d9b53dde3825858808d3994d994610"
DEBFILENAME_libc6-dev = "libc6-dev_2.13-38+rpi2+deb7u8_armhf.deb"
SRC_URI[deb1.sha256sum] = "d974b767c40bd14e3a5adc873e02d5b6e1490f1c0f8da6b123f20e9037b0203a"
SRC_URI[deb1.md5sum] = "1457f0a72d73095238cdb861f3d191f6"
DEBFILENAME_libc6 = "libc6_2.13-38+rpi2+deb7u8_armhf.deb"
SRC_URI[deb2.sha256sum] = "5a17ba8e3d24eebf15f284228b187f13b0556b0b6304f4538e9e279a8a88742c"
SRC_URI[deb2.md5sum] = "83295851be83a40909b0cf2825e0f793"
DEBFILENAME_libc-dev-bin = "libc-dev-bin_2.13-38+rpi2+deb7u8_armhf.deb"
SRC_URI[deb3.sha256sum] = "bdd7b61a594da2476a7ba3ceb0d1574530cd584838dc5a6da91c30a4fb348bab"
SRC_URI[deb3.md5sum] = "86687fdbc41fbb8d07c602ab32add033"

RDEPENDS_libc6-dev = "libc6 (= 2.13-38+rpi2+deb7u8) libc-dev-bin (= 2.13-38+rpi2+deb7u8) linux-libc-dev"
RDEPENDS_libc6 = "libc-bin (= 2.13-38+rpi2+deb7u8) "
RDEPENDS_libc-dev-bin = "libc6 (>= 2.13-28) libc6 (<< 2.14)"
DEPENDS = " linux-libc-dev"


inherit deb_group

# Prebuilt binaries, no need for any default dependencies
INHIBIT_DEFAULT_DEPS = "1"
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} += "already-stripped"

FILES_libc-bin = " \
	./usr/lib/locale/C.UTF-8/LC_MONETARY \
	./usr/lib/locale/C.UTF-8/LC_IDENTIFICATION \
	./usr/bin/tzselect \
	./usr/share/libc-bin/nsswitch.conf \
	./usr/share/man/man8/ld.so.8.gz \
	./usr/share/man/man1/locale.1.gz \
	./usr/bin/locale \
	./usr/share/man/man8/iconvconfig.8.gz \
	./usr/lib/locale/C.UTF-8/LC_MESSAGES/ \
	./usr/lib/locale/C.UTF-8/LC_MEASUREMENT \
	./usr/share/man/man1/iconv.1.gz \
	./usr/bin/zdump \
	./usr/share/doc/libc-bin/TODO.Debian \
	./usr/share/ \
	./etc/gai.conf \
	./etc/ld.so.conf.d/ \
	./usr/share/man/man8/ \
	./usr/share/lintian/ \
	./usr/bin/catchsegv \
	./usr/lib/locale/C.UTF-8/LC_NAME \
	./usr/lib/locale/C.UTF-8/LC_CTYPE \
	./usr/ \
	./ \
	./usr/share/lintian/overrides/libc-bin \
	./usr/sbin/iconvconfig \
	./usr/lib/ \
	./usr/share/man/man1/tzselect.1.gz \
	./usr/lib/locale/C.UTF-8/LC_PAPER \
	./usr/lib/locale/ \
	./usr/share/man/man8/ldconfig.8.gz \
	./usr/sbin/ \
	./usr/share/man/man1/ldd.1.gz \
	./usr/bin/rpcinfo \
	./etc/ \
	./usr/share/man/man5/gai.conf.5.gz \
	./usr/share/doc/libc-bin/ \
	./usr/share/man/man1/getconf.1.gz \
	./usr/bin/localedef \
	./sbin/ \
	./usr/sbin/zic \
	./usr/lib/locale/C.UTF-8/ \
	./usr/lib/locale/C.UTF-8/LC_TIME \
	./etc/bindresvport.blacklist \
	./usr/bin/ \
	./usr/share/man/man8/zic.8.gz \
	./etc/default/ \
	./usr/share/doc/libc-bin/copyright \
	./usr/bin/iconv \
	./usr/share/man/man5/ \
	./etc/default/nss \
	./usr/lib/pt_chown \
	./usr/share/doc/libc-bin/changelog.gz \
	./usr/lib/locale/C.UTF-8/LC_NUMERIC \
	./usr/share/man/man1/ \
	./usr/lib/locale/C.UTF-8/LC_MESSAGES/SYS_LC_MESSAGES \
	./usr/share/man/man1/zdump.1.gz \
	./usr/share/lintian/overrides/ \
	./usr/bin/getent \
	./usr/lib/locale/C.UTF-8/LC_TELEPHONE \
	./sbin/ldconfig \
	./usr/lib/locale/C.UTF-8/LC_ADDRESS \
	./usr/share/man/man1/localedef.1.gz \
	./usr/share/man/man1/catchsegv.1.gz \
	./usr/share/doc/libc-bin/changelog.Debian.gz \
	./usr/bin/ldd \
	./usr/bin/getconf \
	./usr/share/libc-bin/ \
	./usr/share/man/ \
	./usr/lib/locale/C.UTF-8/LC_COLLATE \
	./usr/share/man/man8/rpcinfo.8.gz \
	./usr/share/doc/ \
	./etc/ld.so.conf.d/libc.conf\
"
FILES_libc6-dev = " \
	./usr/include/arm-linux-gnueabihf/bits/sem.h \
	./usr/include/arm-linux-gnueabihf/bits/sockaddr.h \
	./usr/include/inttypes.h \
	./usr/include/arm-linux-gnueabihf/sys/kd.h \
	./usr/include/arm-linux-gnueabihf/bits/mman.h \
	./usr/include/net/if_ppp.h \
	./usr/include/arm-linux-gnueabihf/bits/fenv.h \
	./usr/include/stdint.h \
	./usr/include/arm-linux-gnueabihf/sys/param.h \
	./usr/include/arm-linux-gnueabihf/bits/local_lim.h \
	./usr/include/arm-linux-gnueabihf/bits/pthreadtypes.h \
	./usr/share/doc/libc6-dev/NAMESPACE \
	./usr/include/getopt.h \
	./usr/include/arm-linux-gnueabihf/bits/stdlib-ldbl.h \
	./usr/include/arm-linux-gnueabihf/sys/soundcard.h \
	./usr/include/arm-linux-gnueabihf/sys/ttydefaults.h \
	./usr/include/arm-linux-gnueabihf/sys/personality.h \
	./usr/include/netinet/ip.h \
	./usr/include/arm-linux-gnueabihf/bits/stdlib.h \
	./usr/include/rpcsvc/nis_callback.h \
	./usr/include/scsi/scsi.h \
	./usr/include/_G_config.h \
	./usr/include/arm-linux-gnueabihf/bits/dlfcn.h \
	./usr/include/arm-linux-gnueabihf/bits/error.h \
	./usr/lib/arm-linux-gnueabihf/libm.a \
	./usr/include/arm-linux-gnueabihf/bits/libc-lock.h \
	./usr/include/arm-linux-gnueabihf/sys/dir.h \
	./usr/include/stdio_ext.h \
	./usr/include/elf.h \
	./usr/include/arm-linux-gnueabihf/bits/ipc.h \
	./usr/lib/arm-linux-gnueabihf/libcrypt.a \
	./usr/include/pthread.h \
	./usr/include/poll.h \
	./usr/include/arm-linux-gnueabihf/gnu/lib-names.h \
	./usr/include/arm-linux-gnueabihf/bits/signum.h \
	./usr/include/arm-linux-gnueabihf/bits/libio-ldbl.h \
	./usr/include/arm-linux-gnueabihf/bits/socket.h \
	./usr/lib/arm-linux-gnueabihf/libanl.a \
	./usr/ \
	./usr/include/protocols/timed.h \
	./usr/include/netinet/ether.h \
	./usr/include/ \
	./usr/include/arm-linux-gnueabihf/sys/profil.h \
	./usr/lib/arm-linux-gnueabihf/libnsl.a \
	./usr/include/arm-linux-gnueabihf/bits/dirent.h \
	./usr/include/monetary.h \
	./usr/include/fts.h \
	./usr/lib/arm-linux-gnueabihf/librpcsvc.a \
	./usr/include/arm-linux-gnueabihf/bits/socket2.h \
	./usr/include/tgmath.h \
	./usr/include/arm-linux-gnueabihf/bits/mqueue.h \
	./usr/include/protocols/rwhod.h \
	./usr/include/arm-linux-gnueabihf/sys/cdefs.h \
	./usr/include/arm-linux-gnueabihf/sys/statvfs.h \
	./usr/include/arm-linux-gnueabihf/sys/ttychars.h \
	./usr/include/arm-linux-gnueabihf/bits/errno.h \
	./usr/include/arm-linux-gnueabihf/gnu/libc-version.h \
	./usr/include/arm-linux-gnueabihf/sys/ioctl.h \
	./usr/lib/arm-linux-gnueabihf/libBrokenLocale.so \
	./usr/include/arm-linux-gnueabihf/sys/pci.h \
	./usr/include/rpc/rpc_des.h \
	./usr/include/arm-linux-gnueabihf/bits/stdio-ldbl.h \
	./usr/include/syscall.h \
	./usr/include/pty.h \
	./usr/include/rpcsvc/key_prot.x \
	./usr/include/arm-linux-gnueabihf/sys/socket.h \
	./usr/lib/arm-linux-gnueabihf/libg.a \
	./usr/include/rpcsvc/rstat.x \
	./usr/include/arm-linux-gnueabihf/bits/utsname.h \
	./usr/include/arm-linux-gnueabihf/sys/vtimes.h \
	./usr/include/arm-linux-gnueabihf/bits/wchar2.h \
	./usr/include/rpc/xdr.h \
	./usr/include/arm-linux-gnueabihf/bits/fenvinline.h \
	./usr/include/libgen.h \
	./usr/lib/arm-linux-gnueabihf/libcrypt.so \
	./usr/include/obstack.h \
	./usr/lib/arm-linux-gnueabihf/libpthread.a \
	./usr/include/stab.h \
	./usr/include/arm-linux-gnueabihf/sys/ucontext.h \
	./usr/lib/arm-linux-gnueabihf/libc.a \
	./usr/include/netinet/if_tr.h \
	./usr/include/arm-linux-gnueabihf/bits/stdio_lim.h \
	./usr/include/arm-linux-gnueabihf/bits/nan.h \
	./usr/include/arm-linux-gnueabihf/sys/time.h \
	./usr/include/arm-linux-gnueabihf/bits/posix1_lim.h \
	./usr/include/arm-linux-gnueabihf/sys/sysctl.h \
	./usr/lib/arm-linux-gnueabihf/libbsd-compat.a \
	./usr/include/arm-linux-gnueabihf/sys/procfs.h \
	./usr/include/netipx/ipx.h \
	./usr/include/arm-linux-gnueabihf/bits/confname.h \
	./usr/include/arm-linux-gnueabihf/bits/typesizes.h \
	./usr/include/arm-linux-gnueabihf/bits/xtitypes.h \
	./usr/include/arm-linux-gnueabihf/sys/prctl.h \
	./usr/include/arm-linux-gnueabihf/bits/wchar.h \
	./usr/include/rpcsvc/bootparam_prot.x \
	./usr/include/rpc/key_prot.h \
	./usr/include/aliases.h \
	./usr/lib/ \
	./usr/include/arm-linux-gnueabihf/sys/stropts.h \
	./usr/include/arm-linux-gnueabihf/bits/string.h \
	./usr/include/arm-linux-gnueabihf/bits/select.h \
	./usr/include/gnu-versions.h \
	./usr/include/arm-linux-gnueabihf/bits/types.h \
	./usr/lib/arm-linux-gnueabihf/libnsl.so \
	./usr/include/rpc/types.h \
	./usr/lib/arm-linux-gnueabihf/Scrt1.o \
	./usr/include/arm-linux-gnueabihf/bits/sigthread.h \
	./usr/include/arm-linux-gnueabihf/sys/syslog.h \
	./usr/include/rpc/ \
	./usr/lib/arm-linux-gnueabihf/crt1.o \
	./usr/include/sysexits.h \
	./usr/include/net/ \
	./usr/lib/arm-linux-gnueabihf/libmcheck.a \
	./usr/include/arm-linux-gnueabihf/a.out.h \
	./usr/include/arm-linux-gnueabihf/sys/types.h \
	./usr/include/rpc/pmap_clnt.h \
	./usr/include/arm-linux-gnueabihf/sys/socketvar.h \
	./usr/include/arm-linux-gnueabihf/fpu_control.h \
	./usr/include/netrose/rose.h \
	./usr/include/error.h \
	./usr/include/arm-linux-gnueabihf/bits/syslog-path.h \
	./usr/include/xlocale.h \
	./usr/include/arm-linux-gnueabihf/bits/unistd.h \
	./usr/include/iconv.h \
	./usr/include/arm-linux-gnueabihf/bits/statvfs.h \
	./usr/include/arm-linux-gnueabihf/sys/statfs.h \
	./usr/include/arm-linux-gnueabihf/bits/semaphore.h \
	./usr/include/arm-linux-gnueabihf/sys/msg.h \
	./usr/include/netpacket/packet.h \
	./usr/include/wait.h \
	./usr/include/printf.h \
	./usr/include/paths.h \
	./usr/include/utmp.h \
	./usr/include/strings.h \
	./usr/include/arm-linux-gnueabihf/sys/gmon.h \
	./usr/include/netinet/if_ether.h \
	./usr/include/arm-linux-gnueabihf/sys/queue.h \
	./usr/include/grp.h \
	./usr/include/arm-linux-gnueabihf/sys/syscall.h \
	./usr/include/resolv.h \
	./usr/include/arm-linux-gnueabihf/bits/mqueue2.h \
	./usr/include/arm-linux-gnueabihf/sys/ \
	./usr/include/arm-linux-gnueabihf/sys/mman.h \
	./usr/lib/arm-linux-gnueabihf/libthread_db.so \
	./usr/include/syslog.h \
	./usr/include/arm-linux-gnueabihf/bits/environments.h \
	./usr/include/arm-linux-gnueabihf/bits/setjmp2.h \
	./usr/include/arm-linux-gnueabihf/bits/sigaction.h \
	./usr/include/arm-linux-gnueabihf/ \
	./usr/lib/arm-linux-gnueabihf/libpthread_nonshared.a \
	./usr/lib/arm-linux-gnueabihf/librt.a \
	./usr/include/rpcsvc/nlm_prot.x \
	./usr/include/netipx/ \
	./usr/include/arpa/inet.h \
	./usr/include/complex.h \
	./usr/include/math.h \
	./usr/include/arm-linux-gnueabihf/sys/timerfd.h \
	./usr/lib/arm-linux-gnueabihf/ \
	./usr/include/unistd.h \
	./usr/include/arm-linux-gnueabihf/bits/utmp.h \
	./usr/include/netatalk/ \
	./usr/include/rpc/pmap_rmt.h \
	./usr/lib/arm-linux-gnueabihf/Mcrt1.o \
	./usr/lib/arm-linux-gnueabihf/libresolv.so \
	./usr/include/rpcsvc/nlm_prot.h \
	./usr/include/tar.h \
	./usr/include/sched.h \
	./usr/include/netinet/udp.h \
	./usr/include/arm-linux-gnueabihf/sys/vt.h \
	./usr/include/rpcsvc/nis_callback.x \
	./usr/lib/arm-linux-gnueabihf/crtn.o \
	./usr/include/rpcsvc/nfs_prot.h \
	./usr/include/search.h \
	./usr/include/arm-linux-gnueabihf/sys/sem.h \
	./usr/include/scsi/ \
	./usr/include/arm-linux-gnueabihf/sys/mtio.h \
	./usr/lib/arm-linux-gnueabihf/libcidn.so \
	./usr/include/rpcsvc/bootparam_prot.h \
	./usr/include/utime.h \
	./usr/include/rpcsvc/nfs_prot.x \
	./usr/lib/arm-linux-gnueabihf/libresolv.a \
	./usr/include/netiucv/iucv.h \
	./usr/include/netash/ash.h \
	./usr/include/arm-linux-gnueabihf/bits/monetary-ldbl.h \
	./usr/include/arm-linux-gnueabihf/bits/mathcalls.h \
	./usr/include/arpa/ftp.h \
	./usr/include/nss.h \
	./usr/include/net/if_shaper.h \
	./usr/include/arm-linux-gnueabihf/sys/bitypes.h \
	./usr/include/netpacket/ \
	./usr/include/netash/ \
	./usr/include/arm-linux-gnueabihf/bits/utmpx.h \
	./usr/include/rpc/rpc.h \
	./usr/include/net/ethernet.h \
	./usr/include/fenv.h \
	./usr/include/neteconet/ \
	./usr/include/locale.h \
	./usr/include/malloc.h \
	./usr/include/arm-linux-gnueabihf/bits/waitstatus.h \
	./usr/include/arm-linux-gnueabihf/sys/mount.h \
	./usr/include/netinet/ip_icmp.h \
	./usr/include/fmtmsg.h \
	./usr/lib/arm-linux-gnueabihf/libnss_hesiod.so \
	./usr/include/rpc/auth_unix.h \
	./usr/include/arm-linux-gnueabihf/sys/ipc.h \
	./usr/include/arm-linux-gnueabihf/sys/fsuid.h \
	./usr/include/arm-linux-gnueabihf/sys/sendfile.h \
	./usr/include/arm-linux-gnueabihf/bits/string2.h \
	./usr/include/arm-linux-gnueabihf/bits/syslog.h \
	./usr/include/arm-linux-gnueabihf/ieee754.h \
	./usr/include/arm-linux-gnueabihf/sys/unistd.h \
	./usr/include/shadow.h \
	./usr/include/arm-linux-gnueabihf/bits/elfclass.h \
	./usr/include/arm-linux-gnueabihf/bits/cmathcalls.h \
	./usr/include/termio.h \
	./usr/include/link.h \
	./usr/include/ifaddrs.h \
	./usr/include/arm-linux-gnueabihf/bits/sys_errlist.h \
	./usr/lib/arm-linux-gnueabihf/libc_nonshared.a \
	./usr/include/values.h \
	./usr/include/libintl.h \
	./usr/include/execinfo.h \
	./usr/include/rpc/clnt.h \
	./usr/include/netax25/ \
	./usr/include/rpcsvc/yp_prot.h \
	./usr/include/arm-linux-gnueabihf/sys/kdaemon.h \
	./usr/include/cpio.h \
	./usr/include/netinet/icmp6.h \
	./usr/include/arm-linux-gnueabihf/bits/huge_val.h \
	./usr/include/arm-linux-gnueabihf/bits/in.h \
	./usr/include/mntent.h \
	./usr/share/doc/libc6-dev/README.libm.gz \
	./usr/include/aio.h \
	./usr/share/lintian/overrides/libc6-dev \
	./usr/include/rpc/rpc_msg.h \
	./usr/include/net/if_arp.h \
	./usr/share/doc/libc6-dev/copyright \
	./usr/include/arm-linux-gnueabihf/sys/fcntl.h \
	./usr/include/ustat.h \
	./usr/include/arm-linux-gnueabihf/bits/stdio-lock.h \
	./usr/include/rpcsvc/nis_object.x \
	./usr/include/arm-linux-gnueabihf/sys/timex.h \
	./usr/include/arm-linux-gnueabihf/sys/klog.h \
	./usr/include/rpcsvc/ \
	./usr/lib/arm-linux-gnueabihf/libm.so \
	./usr/include/rpcsvc/klm_prot.h \
	./usr/share/doc/libc6-dev/changelog.gz \
	./usr/include/arm-linux-gnueabihf/bits/shm.h \
	./usr/include/argp.h \
	./usr/include/rpcsvc/klm_prot.x \
	./usr/include/arm-linux-gnueabihf/sys/errno.h \
	./usr/include/netinet/ \
	./usr/include/arm-linux-gnueabihf/sys/raw.h \
	./usr/include/arm-linux-gnueabihf/sys/sysinfo.h \
	./usr/include/arm-linux-gnueabihf/sys/uio.h \
	./usr/include/protocols/routed.h \
	./usr/include/argz.h \
	./usr/include/arm-linux-gnueabihf/bits/stab.def \
	./usr/include/netinet/tcp.h \
	./usr/include/langinfo.h \
	./usr/lib/arm-linux-gnueabihf/libnss_nisplus.so \
	./usr/include/arm-linux-gnueabihf/bits/a.out.h \
	./usr/include/rpc/pmap_prot.h \
	./usr/include/arm-linux-gnueabihf/bits/resource.h \
	./usr/include/time.h \
	./usr/include/net/ppp-comp.h \
	./usr/include/net/route.h \
	./usr/include/dlfcn.h \
	./usr/include/rpcsvc/nis_tags.h \
	./usr/include/arm-linux-gnueabihf/bits/posix_opt.h \
	./usr/include/rpcsvc/mount.h \
	./usr/include/arm-linux-gnueabihf/bits/waitflags.h \
	./usr/share/lintian/overrides/ \
	./usr/include/nl_types.h \
	./usr/include/fnmatch.h \
	./usr/include/wchar.h \
	./usr/include/arm-linux-gnueabihf/sys/io.h \
	./usr/include/arm-linux-gnueabihf/bits/locale.h \
	./usr/include/arm-linux-gnueabihf/bits/syscall.h \
	./usr/include/netdb.h \
	./usr/include/arm-linux-gnueabihf/sys/vfs.h \
	./usr/include/mcheck.h \
	./usr/include/netinet/ip6.h \
	./usr/include/arm-linux-gnueabihf/bits/sigcontext.h \
	./usr/include/arm-linux-gnueabihf/bits/link.h \
	./usr/include/arpa/nameser.h \
	./usr/include/arm-linux-gnueabihf/sys/termios.h \
	./usr/include/arm-linux-gnueabihf/sys/signal.h \
	./usr/include/arm-linux-gnueabihf/bits/stdio.h \
	./usr/include/gshadow.h \
	./usr/include/arm-linux-gnueabihf/bits/mathinline.h \
	./usr/include/rpcsvc/mount.x \
	./usr/include/byteswap.h \
	./usr/include/rpcsvc/nis.h \
	./usr/include/ulimit.h \
	./usr/include/arm-linux-gnueabihf/sys/acct.h \
	./usr/include/arm-linux-gnueabihf/sys/resource.h \
	./usr/include/arm-linux-gnueabihf/bits/ioctls.h \
	./usr/include/arm-linux-gnueabihf/bits/initspin.h \
	./usr/include/arm-linux-gnueabihf/bits/posix2_lim.h \
	./usr/include/arm-linux-gnueabihf/sys/timeb.h \
	./usr/include/rpcsvc/nis.x \
	./usr/include/rpcsvc/key_prot.h \
	./usr/include/arm-linux-gnueabihf/bits/endian.h \
	./usr/include/arpa/telnet.h \
	./usr/include/arm-linux-gnueabihf/sys/epoll.h \
	./usr/include/arm-linux-gnueabihf/sys/select.h \
	./usr/include/nfs/ \
	./usr/include/rpc/netdb.h \
	./usr/include/arm-linux-gnueabihf/sys/gmon_out.h \
	./usr/include/semaphore.h \
	./usr/include/netrom/netrom.h \
	./usr/include/arpa/nameser_compat.h \
	./usr/lib/arm-linux-gnueabihf/libanl.so \
	./usr/lib/arm-linux-gnueabihf/libutil.so \
	./usr/include/arm-linux-gnueabihf/sys/inotify.h \
	./usr/include/signal.h \
	./usr/include/arpa/ \
	./usr/include/net/ppp_defs.h \
	./usr/include/gconv.h \
	./usr/include/rpcsvc/yppasswd.x \
	./usr/include/arm-linux-gnueabihf/sys/times.h \
	./usr/include/rpcsvc/ypupd.h \
	./usr/include/sgtty.h \
	./usr/include/arm-linux-gnueabihf/bits/stropts.h \
	./usr/share/doc/libc6-dev/NOTES.gz \
	./usr/include/arm-linux-gnueabihf/bits/poll.h \
	./usr/include/stdlib.h \
	./usr/share/lintian/ \
	./usr/include/glob.h \
	./usr/include/netatalk/at.h \
	./usr/lib/arm-linux-gnueabihf/libBrokenLocale.a \
	./usr/include/arm-linux-gnueabihf/bits/msq.h \
	./usr/lib/arm-linux-gnueabihf/libdl.so \
	./usr/include/arm-linux-gnueabihf/sys/ustat.h \
	./usr/include/arm-linux-gnueabihf/sys/swap.h \
	./usr/include/arm-linux-gnueabihf/sys/shm.h \
	./usr/share/doc/libc6-dev/changelog.Debian.gz \
	./usr/include/arm-linux-gnueabihf/bits/syslog-ldbl.h \
	./usr/lib/arm-linux-gnueabihf/libutil.a \
	./usr/include/endian.h \
	./usr/include/libio.h \
	./usr/include/arm-linux-gnueabihf/bits/fcntl.h \
	./usr/include/re_comp.h \
	./usr/lib/arm-linux-gnueabihf/libnss_compat.so \
	./usr/include/rpcsvc/rusers.h \
	./usr/include/lastlog.h \
	./usr/include/rpc/auth_des.h \
	./usr/include/arm-linux-gnueabihf/bits/ipctypes.h \
	./usr/include/rpcsvc/rusers.x \
	./usr/include/arm-linux-gnueabihf/sys/poll.h \
	./usr/include/arm-linux-gnueabihf/bits/sched.h \
	./usr/include/ar.h \
	./usr/include/ttyent.h \
	./usr/include/arm-linux-gnueabihf/bits/termios.h \
	./usr/include/alloca.h \
	./usr/include/termios.h \
	./usr/lib/arm-linux-gnueabihf/libnss_dns.so \
	./usr/include/protocols/talkd.h \
	./usr/include/scsi/sg.h \
	./usr/include/assert.h \
	./usr/include/neteconet/ec.h \
	./usr/share/doc/libc6-dev/FAQ.gz \
	./usr/include/net/if.h \
	./usr/include/ftw.h \
	./usr/include/regex.h \
	./usr/include/stdio.h \
	./usr/include/arm-linux-gnueabihf/gnu/ \
	./usr/include/netrom/ \
	./usr/lib/arm-linux-gnueabihf/libnss_nis.so \
	./usr/include/setjmp.h \
	./usr/include/rpc/svc.h \
	./usr/include/rpcsvc/spray.x \
	./usr/include/arm-linux-gnueabihf/sys/elf.h \
	./usr/include/arm-linux-gnueabihf/bits/string3.h \
	./usr/include/arm-linux-gnueabihf/sys/signalfd.h \
	./usr/include/rpcsvc/spray.h \
	./usr/lib/arm-linux-gnueabihf/crti.o \
	./usr/include/arm-linux-gnueabihf/bits/statfs.h \
	./usr/lib/arm-linux-gnueabihf/libnss_files.so \
	./usr/include/arm-linux-gnueabihf/sys/file.h \
	./usr/lib/arm-linux-gnueabihf/libieee.a \
	./usr/include/err.h \
	./usr/include/arm-linux-gnueabihf/bits/printf-ldbl.h \
	./usr/include/stropts.h \
	./usr/lib/arm-linux-gnueabihf/libpthread.so \
	./usr/include/arm-linux-gnueabihf/bits/mathdef.h \
	./usr/include/arm-linux-gnueabihf/gnu/stubs.h \
	./usr/include/arm-linux-gnueabihf/bits/siginfo.h \
	./usr/include/mqueue.h \
	./usr/include/arm-linux-gnueabihf/sys/xattr.h \
	./usr/include/rpcsvc/yppasswd.h \
	./usr/include/arm-linux-gnueabihf/bits/predefs.h \
	./usr/include/limits.h \
	./usr/include/rpcsvc/rex.h \
	./usr/include/rpcsvc/sm_inter.x \
	./usr/lib/arm-linux-gnueabihf/librt.so \
	./usr/include/arm-linux-gnueabihf/sys/vlimit.h \
	./usr/include/fstab.h \
	./usr/include/rpcsvc/rex.x \
	./usr/include/rpcsvc/sm_inter.h \
	./usr/share/ \
	./usr/include/protocols/ \
	./usr/include/arm-linux-gnueabihf/bits/xopen_lim.h \
	./usr/include/netrose/ \
	./usr/include/net/if_slip.h \
	./usr/include/arm-linux-gnueabihf/bits/stat.h \
	./usr/include/arm-linux-gnueabihf/bits/ioctl-types.h \
	./usr/include/errno.h \
	./usr/include/arm-linux-gnueabihf/sys/fanotify.h \
	./usr/include/envz.h \
	./usr/include/arm-linux-gnueabihf/bits/stdio2.h \
	./usr/include/thread_db.h \
	./usr/include/rpcsvc/rquota.x \
	./usr/include/net/if_packet.h \
	./usr/lib/arm-linux-gnueabihf/gcrt1.o \
	./usr/include/features.h \
	./usr/include/rpcsvc/rquota.h \
	./usr/include/arm-linux-gnueabihf/bits/byteswap.h \
	./usr/include/wordexp.h \
	./usr/include/arm-linux-gnueabihf/sys/un.h \
	./usr/include/rpcsvc/yp.h \
	./usr/include/arm-linux-gnueabihf/bits/sigstack.h \
	./usr/include/rpc/des_crypt.h \
	./usr/include/rpcsvc/nislib.h \
	./usr/include/netinet/if_fddi.h \
	./usr/lib/arm-linux-gnueabihf/libc.so \
	./usr/include/pwd.h \
	./usr/include/rpcsvc/ypclnt.h \
	./usr/include/arm-linux-gnueabihf/bits/wchar-ldbl.h \
	./usr/include/arm-linux-gnueabihf/sys/reboot.h \
	./usr/include/netax25/ax25.h \
	./usr/include/arm-linux-gnueabihf/bits/netdb.h \
	./usr/include/arm-linux-gnueabihf/sys/ptrace.h \
	./usr/include/arm-linux-gnueabihf/sys/wait.h \
	./ \
	./usr/include/nfs/nfs.h \
	./usr/include/netiucv/ \
	./usr/include/arm-linux-gnueabihf/gnu/option-groups.h \
	./usr/include/rpcsvc/rstat.h \
	./usr/include/arm-linux-gnueabihf/bits/sigset.h \
	./usr/include/arm-linux-gnueabihf/bits/time.h \
	./usr/include/arm-linux-gnueabihf/sys/quota.h \
	./usr/include/netinet/in_systm.h \
	./usr/include/netinet/igmp.h \
	./usr/include/arpa/tftp.h \
	./usr/share/doc/libc6-dev/ \
	./usr/include/string.h \
	./usr/lib/arm-linux-gnueabihf/libdl.a \
	./usr/include/arm-linux-gnueabihf/bits/huge_vall.h \
	./usr/include/memory.h \
	./usr/include/ucontext.h \
	./usr/share/doc/libc6-dev/CONFORMANCE.gz \
	./usr/include/arm-linux-gnueabihf/bits/wordsize.h \
	./usr/include/ctype.h \
	./usr/include/spawn.h \
	./usr/include/netinet/in.h \
	./usr/include/scsi/scsi_ioctl.h \
	./usr/include/utmpx.h \
	./usr/include/arm-linux-gnueabihf/sys/utsname.h \
	./usr/include/fcntl.h \
	./usr/include/arm-linux-gnueabihf/bits/setjmp.h \
	./usr/include/arm-linux-gnueabihf/bits/inf.h \
	./usr/include/dirent.h \
	./usr/include/arm-linux-gnueabihf/bits/huge_valf.h \
	./usr/include/rpcsvc/yp.x \
	./usr/include/rpc/svc_auth.h \
	./usr/include/arm-linux-gnueabihf/sys/user.h \
	./usr/include/arm-linux-gnueabihf/bits/fcntl2.h \
	./usr/include/wctype.h \
	./usr/include/arm-linux-gnueabihf/bits/ustat.h \
	./usr/include/arm-linux-gnueabihf/sys/ultrasound.h \
	./usr/include/rpc/auth.h \
	./usr/include/arm-linux-gnueabihf/bits/ \
	./usr/include/rpcsvc/bootparam.h \
	./usr/include/arm-linux-gnueabihf/sys/stat.h \
	./usr/include/arm-linux-gnueabihf/sys/sysmacros.h \
	./usr/include/crypt.h \
	./usr/include/arm-linux-gnueabihf/bits/uio.h \
	./usr/include/arm-linux-gnueabihf/sys/eventfd.h \
	./usr/include/regexp.h \
	./usr/share/doc/\
"
FILES_libc6 = " \
	./usr/lib/arm-linux-gnueabihf/gconv/SAMI-WS2.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM5347.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1153.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1129.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-IR-197.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-DK-NO-A.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1251.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1253.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM424.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1154.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GOST_19768-74.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-10.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM281.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1130.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EUC-KR.so \
	./usr/lib/arm-linux-gnueabihf/gconv/LATIN-GREEK.so \
	./lib/arm-linux-gnueabihf/libnss_nisplus-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP737.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GBBIG5.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-7.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISIRI-3342.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EUC-CN.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM275.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1399.so \
	./lib/arm-linux-gnueabihf/librt-2.13.so \
	./lib/arm-linux-gnueabihf/libdl-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ARMSCII-8.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GBK.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-CA-FR.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM937.so \
	./usr/lib/arm-linux-gnueabihf/gconv/TSCII.so \
	./usr/lib/arm-linux-gnueabihf/gconv/MIK.so \
	./usr/share/doc/libc6/changelog.Debian.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-FR.so \
	./usr/lib/arm-linux-gnueabihf/gconv/MAC-SAMI.so \
	./usr/lib/arm-linux-gnueabihf/gconv/NATS-DANO.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1124.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1390.so \
	./usr/lib/arm-linux-gnueabihf/gconv/UTF-16.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-IR-209.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-11.so \
	./lib/arm-linux-gnueabihf/libnss_nis-2.13.so \
	./lib/arm-linux-gnueabihf/ld-linux-armhf.so.3 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM866.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-IT.so \
	./usr/share/doc/libc6/NEWS.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM902.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1143.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GREEK7.so \
	./usr/lib/arm-linux-gnueabihf/gconv/UNICODE.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM874.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1123.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-FI-SE-A.so \
	./usr/lib/arm-linux-gnueabihf/gconv/libGB.so \
	./usr/lib/arm-linux-gnueabihf/gconv/HP-ROMAN8.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EUC-JP-MS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM423.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1167.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GEORGIAN-ACADEMY.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ASMO_449.so \
	./lib/arm-linux-gnueabihf/libBrokenLocale.so.1 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM901.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-US.so \
	./lib/arm-linux-gnueabihf/libthread_db-1.0.so \
	./lib/arm-linux-gnueabihf/libcidn.so.1 \
	./lib/arm-linux-gnueabihf/libthread_db.so.1 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM290.so \
	./usr/share/lintian/overrides/ \
	./usr/lib/arm-linux-gnueabihf/gconv/EUC-JISX0213.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1008_420.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1125.so \
	./lib/arm-linux-gnueabihf/libpthread-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/gconv-modules \
	./etc/ld.so.conf.d/arm-linux-gnueabihf.conf \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM875.so \
	./usr/lib/arm-linux-gnueabihf/gconv/SJIS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-1.so \
	./lib/arm-linux-gnueabihf/ld-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ANSI_X3.110.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM16804.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-AT-DE-A.so \
	./usr/lib/arm-linux-gnueabihf/gconv/NATS-SEFI.so \
	./lib/arm-linux-gnueabihf/libanl-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1141.so \
	./usr/lib/arm-linux-gnueabihf/gconv/MAC-UK.so \
	./lib/arm-linux-gnueabihf/libcidn-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP932.so \
	./usr/lib/arm-linux-gnueabihf/gconv/LATIN-GREEK-1.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO646.so \
	./usr/lib/arm-linux-gnueabihf/gconv/TCVN5712-1.so \
	./usr/lib/arm-linux-gnueabihf/gconv/BRF.so \
	./lib/arm-linux-gnueabihf/libnss_dns-2.13.so \
	./usr/lib/arm-linux-gnueabihf/ \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM905.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM284.so \
	./lib/arm-linux-gnueabihf/libm.so.6 \
	./usr/lib/arm-linux-gnueabihf/gconv/libISOIR165.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM9448.so \
	./usr/share/ \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM4971.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1025.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM855.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM930.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GREEK-CCITT.so \
	./usr/share/doc/libc6/BUGS \
	./usr/ \
	./usr/lib/arm-linux-gnueabihf/gconv/EUC-TW.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1140.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1097.so \
	./usr/lib/arm-linux-gnueabihf/gconv/RK1048.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM866NAV.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GREEK7-OLD.so \
	./usr/share/doc/ \
	./usr/lib/arm-linux-gnueabihf/gconv/UTF-32.so \
	./usr/lib/arm-linux-gnueabihf/gconv/gconv-modules.cache \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM12712.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM273.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-2022-CN-EXT.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM891.so \
	./lib/arm-linux-gnueabihf/libmemusage.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1160.so \
	./usr/lib/arm-linux-gnueabihf/gconv/libJISX0213.so \
	./usr/lib/arm-linux-gnueabihf/gconv/libCNS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM871.so \
	./usr/lib/arm-linux-gnueabihf/gconv/INIS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1257.so \
	./usr/share/doc/libc6/FAQ.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_11548-1.so \
	./usr/lib/arm-linux-gnueabihf/gconv/VISCII.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-9E.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM274.so \
	./usr/share/doc/libc6/ \
	./usr/lib/arm-linux-gnueabihf/gconv/KOI8-RU.so \
	./lib/arm-linux-gnueabihf/libSegFault.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CWI.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_5427-EXT.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM860.so \
	./lib/arm-linux-gnueabihf/librt.so.1 \
	./lib/arm-linux-gnueabihf/libpthread.so.0 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM862.so \
	./lib/arm-linux-gnueabihf/ld-linux.so.3 \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1258.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM297.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GEORGIAN-PS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_6937-2.so \
	./lib/arm-linux-gnueabihf/libresolv-2.13.so \
	./lib/arm-linux-gnueabihf/libc-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-AT-DE.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1155.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM277.so \
	./usr/lib/arm-linux-gnueabihf/gconv/KOI8-R.so \
	./usr/share/doc/libc6/README.Debian.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_2033.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1166.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1164.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-5.so \
	./usr/lib/arm-linux-gnueabihf/gconv/MAC-IS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-UK.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM921.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1161.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM038.so \
	./usr/share/doc/libc6/NEWS.Debian.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM870.so \
	./lib/arm-linux-gnueabihf/libnss_compat-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_6937.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-4.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1008.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM865.so \
	./lib/arm-linux-gnueabihf/ \
	./usr/lib/arm-linux-gnueabihf/gconv/UHC.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IEC_P27-1.so \
	./usr/lib/arm-linux-gnueabihf/gconv/PT154.so \
	./usr/lib/arm-linux-gnueabihf/gconv/libKSC.so \
	./lib/arm-linux-gnueabihf/libanl.so.1 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM922.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM918.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-FI-SE.so \
	./lib/ld-linux-armhf.so.3 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1148.so \
	./etc/ld.so.conf.d/ \
	./lib/arm-linux-gnueabihf/libpcprofile.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-2.so \
	./usr/lib/arm-linux-gnueabihf/gconv/HP-TURKISH8.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-DK-NO.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-2022-CN.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1147.so \
	./usr/share/doc/libc6/changelog.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_10367-BOX.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1256.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM904.so \
	./ \
	./usr/lib/arm-linux-gnueabihf/gconv/libJIS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1133.so \
	./usr/lib/arm-linux-gnueabihf/gconv/MAC-CENTRALEUROPE.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1163.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EUC-JP.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM857.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM852.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM9066.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-13.so \
	./lib/arm-linux-gnueabihf/libutil.so.1 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM420.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1047.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CSN_369103.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM803.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1156.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM880.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM4517.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM850.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-PT.so \
	./lib/arm-linux-gnueabihf/libnss_dns.so.2 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM932.so \
	./lib/arm-linux-gnueabihf/libnss_files.so.2 \
	./usr/share/doc/libc6/copyright \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1388.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM256.so \
	./usr/lib/arm-linux-gnueabihf/gconv/HP-GREEK8.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1004.so \
	./usr/share/doc/libc6/README.hesiod.gz \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1145.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-IS-FRISS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/TIS-620.so \
	./usr/lib/arm-linux-gnueabihf/gconv/HP-THAI8.so \
	./lib/arm-linux-gnueabihf/libnss_nis.so.2 \
	./usr/share/lintian/ \
	./usr/lib/arm-linux-gnueabihf/gconv/HP-ROMAN9.so \
	./usr/lib/arm-linux-gnueabihf/gconv/BIG5HKSCS.so \
	./usr/lib/arm-linux-gnueabihf/gconv/SHIFT_JISX0213.so \
	./usr/lib/arm-linux-gnueabihf/gconv/MACINTOSH.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP775.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1146.so \
	./lib/ \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1252.so \
	./lib/arm-linux-gnueabihf/libnss_files-2.13.so \
	./lib/arm-linux-gnueabihf/libnss_compat.so.2 \
	./usr/lib/arm-linux-gnueabihf/gconv/INIS-CYRILLIC.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-3.so \
	./usr/lib/arm-linux-gnueabihf/gconv/DEC-MCS.so \
	./lib/arm-linux-gnueabihf/libnss_hesiod.so.2 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1162.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1364.so \
	./lib/arm-linux-gnueabihf/libresolv.so.2 \
	./lib/arm-linux-gnueabihf/libm-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/INIS-8.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1157.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1026.so \
	./usr/lib/arm-linux-gnueabihf/gconv/KOI8-T.so \
	./lib/arm-linux-gnueabihf/libnss_nisplus.so.2 \
	./lib/arm-linux-gnueabihf/libutil-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1149.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-2022-JP-3.so \
	./usr/lib/arm-linux-gnueabihf/gconv/KOI-8.so \
	./lib/arm-linux-gnueabihf/libcrypt-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1254.so \
	./lib/arm-linux-gnueabihf/libBrokenLocale-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-15.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1144.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1142.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1112.so \
	./usr/share/lintian/overrides/libc6 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1371.so \
	./lib/arm-linux-gnueabihf/libc.so.6 \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM903.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1122.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM285.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM864.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-14.so \
	./usr/lib/arm-linux-gnueabihf/gconv/JOHAB.so \
	./usr/lib/ \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-2022-JP.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM500.so \
	./usr/lib/arm-linux-gnueabihf/gconv/UTF-7.so \
	./usr/lib/arm-linux-gnueabihf/gconv/BIG5.so \
	./usr/lib/arm-linux-gnueabihf/gconv/T.61.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM037.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-9.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO-2022-KR.so \
	./usr/lib/arm-linux-gnueabihf/gconv/KOI8-U.so \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1250.so \
	./etc/ \
	./usr/lib/arm-linux-gnueabihf/gconv/CP10007.so \
	./lib/arm-linux-gnueabihf/libcrypt.so.1 \
	./usr/lib/arm-linux-gnueabihf/gconv/GB18030.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM868.so \
	./usr/share/doc/libc6/test-results-arm-linux-gnueabihf-libc \
	./usr/lib/arm-linux-gnueabihf/gconv/CP1255.so \
	./lib/arm-linux-gnueabihf/libnsl.so.1 \
	./lib/arm-linux-gnueabihf/libnsl-2.13.so \
	./lib/arm-linux-gnueabihf/libdl.so.2 \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-ES.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM278.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-6.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_5427.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM939.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM851.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM861.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1132.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-ES-S.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO_5428.so \
	./usr/lib/arm-linux-gnueabihf/gconv/EBCDIC-ES-A.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM933.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM437.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-8.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1158.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM856.so \
	./usr/lib/arm-linux-gnueabihf/gconv/GBGBK.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ECMA-CYRILLIC.so \
	./lib/arm-linux-gnueabihf/libnss_hesiod-2.13.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM4899.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1046.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM4909.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM869.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM1137.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM280.so \
	./usr/lib/arm-linux-gnueabihf/gconv/ISO8859-16.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM943.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM9030.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM863.so \
	./usr/lib/arm-linux-gnueabihf/gconv/IBM935.so\
"
FILES_libc-dev-bin = " \
	./usr/share/doc/libc-dev-bin/copyright \
	./usr/bin/sprof \
	./usr/share/man/man1/rpcgen.1.gz \
	./usr/ \
	./ \
	./usr/share/doc/libc-dev-bin/ \
	./usr/bin/ \
	./usr/share/doc/libc-dev-bin/NAMESPACE \
	./usr/share/doc/libc-dev-bin/NOTES.gz \
	./usr/share/man/man1/ \
	./usr/share/doc/libc-dev-bin/changelog.gz \
	./usr/bin/mtrace \
	./usr/bin/rpcgen \
	./usr/share/man/man1/sprof.1.gz \
	./usr/share/man/man1/gencat.1.gz \
	./usr/share/man/ \
	./usr/share/ \
	./usr/share/man/man1/mtrace.1.gz \
	./usr/bin/gencat \
	./usr/share/doc/ \
	./usr/share/doc/libc-dev-bin/changelog.Debian.gz\
"
#FAKE LICENSE FOR TESTING!!!
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
