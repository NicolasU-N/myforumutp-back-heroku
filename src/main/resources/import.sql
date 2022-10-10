INSERT INTO usuario (username,password, correo, created_at, celular) VALUES ("Nicolás","$2a$12$MkR4lVU1UwfF8Xn1gzVOjONdwI/IldsAfuwKSVHw428JbJSwLj9IW","nicolas@gmail.com",NOW(),"3157857788");

INSERT INTO usuario (username, password, correo, created_at, celular) VALUES ("Andrés","$2a$12$MkR4lVU1UwfF8Xn1gzVOjONdwI/IldsAfuwKSVHw428JbJSwLj9IW","andres@gmail.com",NOW(),"3157854433");

INSERT INTO publicacion (usuario_id, parent_id, asunto, contenido, created_at, created_by) VALUES (1,NULL,"como importar un proyecto en intellij idea?","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed vehicula massa. In in sem ultricies, iaculis felis a, ornare nunc. Nulla condimentum suscipit lacus eu pulvinar. Praesent id varius nibh. Quisque est augue, rutrum vel erat in, vulputate condimentum libero. Nullam id hendrerit dolor. In ac auctor leo, sed rutrum sapien. Ut eleifend, sem et posuere ultricies, tortor metus accumsan felis, at ultrices lacus nisi in lectus. Aliquam mollis malesuada leo non commodo.",NOW(),1);

INSERT INTO publicacion (usuario_id, parent_id, asunto, contenido, created_at, created_by) VALUES (2,1,"RE: como importar un proyecto en intellij idea?","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed vehicula massa. In in sem ultricies, iaculis felis a, ornare nunc. Nulla condimentum suscipit lacus eu pulvinar. ",NOW(),1);

INSERT INTO voto(likes, dislikes, publicacion_id, created_at) VALUES (1, 0, 1, NOW());

INSERT INTO rol (nombre,created_at) VALUES ("admin",NOW());

INSERT INTO rol (nombre,created_at) VALUES ("usuario",NOW());

INSERT INTO usuario_rol(rol_id,usuario_id) VALUES (1, 1);

INSERT INTO usuario_rol (rol_id,usuario_id) VALUES (2, 2);