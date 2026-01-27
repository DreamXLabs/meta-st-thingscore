FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/fragments/${LINUX_VERSION}/fragment-01-enable-wf200-driver.config"
SRC_URI:append = " file://${LINUX_VERSION}/fragment-01-enable-wf200-driver.config;subdir=fragments "