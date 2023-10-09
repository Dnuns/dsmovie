INSERT INTO tb_user(created_time, email, name, password, role) VALUES (NOW(),'maria.123@gmail.com', 'Maria', 'maria123', 'ADMIN');
INSERT INTO tb_user(created_time, email, name, password, role) VALUES (NOW(),'carlos.123@gmail.com','Carlos', 'carlos123', 'USER');

INSERT INTO tb_movie(score, count, title, image) VALUES (0.0, 1, 'O Rei Macaco', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bmwK5QCznqUT8bcDR7qROrxqgov.jpg');

INSERT INTO tb_score(movie_id, user_id, value) VALUES (1, 1, 0.0);