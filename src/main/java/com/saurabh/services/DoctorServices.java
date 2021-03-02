package com.saurabh.services;

import java.util.List;

import com.saurabh.entities.Doctor;

public interface DoctorServices {
	public int create(Doctor doctor);
	public int delete(int id);
	public List<Doctor> search(String name);
}
