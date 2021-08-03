DESCRIPTION = "Daemon which interfaces IOBus-devices from Linux Automation GmbH with test-automation tools like labgrid."
HOMEPAGE = "https://github.com/linux-automation/lxa-iobus"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0674f4b6076ccd96a8b400a746f71dd3"

RDEPENDS_${PN} = " \
    bash \
    git \
    python3-aiohttp \
    python3-aiohttp-json-rpc \
    python3-can \
    python3-janus \
    python3-setuptools \
    python3-twine \
"

SRC_URI = " \
    git://github.com/linux-automation/lxa-iobus.git;branch=master \
    file://80_can0-iobus.link \
    file://80_can0-iobus.network \
    file://lxa-iobus.service \
    "

SRCREV = "4c9a59df086d23df7a9a5c7c3a78ed8c6ef12f99"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit setuptools3

do_install_append() {
    install -D -m0644 ${WORKDIR}/80_can0-iobus.link ${D}${libdir}/systemd/network/80_can0-iobus.link
    install -D -m0644 ${WORKDIR}/80_can0-iobus.network ${D}${libdir}/systemd/network/80_can0-iobus.network
    install -D -m0644 ${WORKDIR}/lxa-iobus.service ${D}${libdir}/systemd/system/lxa-iobus.service
}

FILES_${PN} += "${libdir}"
