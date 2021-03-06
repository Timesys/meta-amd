require recipes-graphics/xorg-driver/xorg-driver-video.inc

SUMMARY = "X.Org X server -- ATI integrated graphics chipsets driver"

DESCRIPTION = "xf86-video-ati is an Xorg driver for Intel integrated	\
graphics chipsets. The driver supports depths 8, 15, 16 and 24. On	\
some chipsets, the driver supports hardware accelerated 3D via the	\
Direct Rendering Infrastructure (DRI)."

LIC_FILES_CHKSUM = "file://COPYING;md5=aabff1606551f9461ccf567739af63dc"

DEPENDS += "virtual/libx11 drm dri2proto glproto \
	    virtual/libgl xineramaproto libpciaccess \
	    udev glamor-egl"

SRCREV = "0333f5bda27dc0ec2edc180c7a4dc9a432f13f97"
PV = "7.3.0+git${SRCPV}"
PR = "${INC_PR}.1"

EXTRA_OECONF += "--enable-udev --enable-glamor"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/driver/xf86-video-ati"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "libgbm-gallium \
		   mesa-driver-radeon \
		   mesa-driver-radeonsi \
		   mesa-driver-swrast \
		  "

COMPATIBLE_HOST = '(i.86|x86_64).*-linux'
