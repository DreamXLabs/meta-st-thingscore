DESCRIPTION = "Thingscore overlay for WF200 firmware and configs"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "\
    file://lib/firmware/wfx/wfm_wf200_C0.sec \
    file://lib/firmware/wfx/wf200.pds \
"

S = "${WORKDIR}"

do_install() {
    # Firmware and PDS file for WF200
    install -d  ${D}/lib/firmware/wfx/
    install -m 0755 ${WORKDIR}/lib/firmware/wfx/wfm_wf200_C0.sec ${D}/lib/firmware/wfx/
    install -m 0755 ${WORKDIR}/lib/firmware/wfx/wf200.pds  ${D}/lib/firmware/wfx/
}

# Skip QA test - placing it at the top it breaks it for a reason 
INSANE_SKIP:${PN} += "usrmerge"

FILES:${PN} += "/lib/firmware/wfx /etc"