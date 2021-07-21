DESCRIPTION = "Control software for Linux Automation GmbH USB-Mux that enables automated testing of embedded USB devices."
HOMEPAGE = "https://github.com/linux-automation/usbmuxctl"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

RDEPENDS_${PN} = " \
    python3-pyusb \
    python3-setuptools \
    python3-termcolor \
    python3-twine \
"

SRC_URI = " \
    git://github.com/linux-automation/usbmuxctl.git;branch=master \
    file://99-usbmux.rules \
    "

SRCREV = "6c0efd7997d4a4c7be1253049b430645e530c25c"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit setuptools3

do_install_append() {
    install -D -m0644 ${WORKDIR}/99-usbmux.rules ${D}${sysconfdir}/udev/rules.d/99-usbmux.rules
}

FILES_${PN} += "${sysconfdir}"
