LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fcc629d7a228e5e3e54c2fa1d73f774"

SRCREV = "c2a9de8e3c72622027698936ff461cba45370454"
SRC_URI = "git://github.com/limbouser/flutter_wayland.git;protocol=https;branch=wayland-box"

DEPENDS =+ " flutter-engine wayland virtual/libgl waylandpp libxkbcommon rapidjson"

RDEPENDS_${PN} = " flutter-engine wayland broadcom-refsw freetype waylandpp libxkbcommon rapidjson"

REQUIRED_DISTRO_FEATURES = "wayland"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DFLUTTER_ENGINE_LIBRARY=${STAGING_LIBDIR}/libflutter_engine.so \
    "

FILES_${PN}  = "${bindir}/flutter_wayland"
