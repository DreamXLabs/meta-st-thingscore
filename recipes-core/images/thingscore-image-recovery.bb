DESCRIPTION = "ThingsCore recovery NAND image"
LICENSE = "MIT"

# Include default core-minimal recipe
require recipes-core/images/core-image-minimal.bb

# UBI filesystem types used for NAND image 
IMAGE_FSTYPES = "ubifs ubi multiubi"

# Install packages
IMAGE_INSTALL:append = "\
    i2c-tools \
    wireguard-tools \
    iw wpa-supplicant \
    iproute2 \
    curl wget \
    gzip tar \ 
    util-linux-lsblk util-linux-blkid \
    parted util-linux-fdisk \
    e2fsprogs \
    openssh \
"

# Install kernel modules
IMAGE_INSTALL += "kernel-modules"

# Append file overlay for WF200
IMAGE_INSTALL:append = " thingscore-main-overlay"
