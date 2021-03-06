FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
EXTRA_OECONF += "--with-system-data-files"
PACKAGECONFIG[glut] = "--with-glut=${STAGING_EXECPREFIXDIR},--without-glut,"
DEPENDS_append_amd = " mesa-glut glew"
PACKAGECONFIG_append_amd = " glut"

SRC_URI += " \
           file://0001-mesa-demos-Use-DEMOS_DATA_DIR-to-locate-data-files.patch \
           file://0001-mesa-demos-Add-missing-data-files.patch \
           file://0001-opengles2-es2tri-add-precision-qualifier-to-the-frag.patch \
"

do_install_append () {
    install -m 0644 ${S}/src/perf/*.frag \
                    ${S}/src/perf/*.vert \
                    ${S}/src/glsl/*.frag \
                    ${S}/src/glsl/*.vert \
                    ${S}/src/glsl/*.geom \
                    ${S}/src/glsl/*.glsl ${D}${datadir}/${BPN}
}
