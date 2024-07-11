package com.proyecto.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorage {


	public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

	//El BuketName es el <id_del_proyecto>"
	final String BucketName = "proyectoappsweb-1ca6f.appspot.com";

	//Esta es la ruta básica de este proyecto Techshop
	final String rutaSuperiorStorage = "proyectoappsweb";

	//Ubicación donde se encuentra el archivo de configuración Json
	final String rutaJsonFile = "firebase";

	//El nombre del archivo Json
	final String archivoJsonFile = "proyectoappsweb-1ca6f-firebase-adminsdk-2v7q3-9f6deb8d7a.json";

}
