DESCRIPTION = "Mixed sync-async queue to interoperate between asyncio tasks and classic threads"
HOMEPAGE = "https://github.com/aio-libs/janus/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23878c357ebb4c8ce1109be365043349"

RDEPENDS_${PN} = " \
"

SRC_URI = " \
    git://github.com/aio-libs/janus.git;branch=master \
    "

SRCREV = "9fb1ae5dc7bb503d54e7dffd73f157a9eb4009d1"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit setuptools3

RDEPENDS_${PN} += "python3-asyncio python3-core python3-threading"
