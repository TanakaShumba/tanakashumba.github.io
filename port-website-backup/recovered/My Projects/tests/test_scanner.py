from ipaddress import ip_network

def test_subnet_parsing():
    subnet = ip_network("192.168.1.0/30")
    assert len(list(subnet.hosts())) == 2
