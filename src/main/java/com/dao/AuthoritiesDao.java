package com.dao;

import java.util.List;

import com.model.Authorities;

public interface AuthoritiesDao {
public List<Authorities> getAuthoritiesByEmail(String emailId);
}
