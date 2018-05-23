package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Administrator;

import java.io.Serializable;

public interface AdministratorService extends Serializable {

    Administrator login (String username, String password);
}