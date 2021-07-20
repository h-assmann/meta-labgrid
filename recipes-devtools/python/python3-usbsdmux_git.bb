DESCRIPTION = "Control software for usb-sd-mux that switches a SD-Card between a Device Under Test (DUT) and a host PC."
HOMEPAGE = "https://github.com/linux-automation/usbsdmux"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

RDEPENDS_${PN} = " \
    python3-setuptools \
    python3-twine \
"

SRC_URI = " \
    git://github.com/linux-automation/usbsdmux.git;branch=master \
    file://99-usbsdmux.rules \
    "

SRCREV = "d326acaa47c7c58a0825b3f9f619bb949b535f46"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit setuptools3

do_install_append() {
    install -D -m0644 ${WORKDIR}/99-usbsdmux.rules ${D}${sysconfdir}/udev/rules.d/99-usbsdmux.rules
}

FILES_${PN} += "${sysconfdir}"
