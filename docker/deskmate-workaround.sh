sudo setfacl --modify user:sl01:rw /var/run/docker.sock
sudo aa-remove-unknown
sudo apparmor_parser -r /etc/apparmor.d/*snap-confine*
sudo apparmor_parser -r /var/lib/snapd/apparmor/profiles/snap-confine*
sudo apparmor_parser -r /var/lib/snapd/apparmor/profiles/snap.docker.compose