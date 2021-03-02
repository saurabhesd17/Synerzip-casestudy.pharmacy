package com.saurabh.entities;

public class Pharmacy {
	private int id;
	private String name;
	private long license;
	private String address;
	private long contact;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getLicense() {
		return license;
	}

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLicense(long license) {
		this.license = license;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", name=" + name + ", license=" + license + ", address=" + address + ", contact="
				+ contact + "]";
	}
}
