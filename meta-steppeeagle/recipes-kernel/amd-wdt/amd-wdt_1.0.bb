DESCRIPTION = "This kernel module provides support for AMD Watchdog driver"
LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://amd_wdt.c;md5=8b8efe83eff938c6f17592973d38e70d \
                    file://amd_wdt.h;md5=29c5be1a55c35b14a9bde439b9de839e \
                    file://Makefile;md5=111ec65dfed99f6cd330ccb4957fb924 \
                   "

inherit module

PR = "r0"
PV = "1.0"

SRC_URI = "file://Makefile \
           file://amd_wdt.c \
           file://amd_wdt.h \
          "

S = "${WORKDIR}"

# Kernel module packages MUST begin with 'kernel-module-', otherwise
# multilib image generation can fail.
#
# The following line is only necessary if the recipe name does not begin
# with kernel-module-.
#
PKG_${PN} = "kernel-module-${PN}"

FILES_${PN} += "${sysconfdir}"
