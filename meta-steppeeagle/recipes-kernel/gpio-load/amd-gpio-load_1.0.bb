DESCRIPTION = "Configuration file to pass module load parameters to AMD GPIO driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://modprobe.d/gpio-amd.conf"

PR = "r0"
PV = "1.0"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/modprobe.d/
    install -m 0644 modprobe.d/gpio-amd.conf ${D}${sysconfdir}/modprobe.d/
}

FILES_${PN} = "${sysconfdir}/modprobe.d"
