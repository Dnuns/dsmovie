INSERT INTO tb_user(email, name, password, role) VALUES ('maria.123@gmail.com', 'Maria', 'maria123', null);
INSERT INTO tb_user(email, name, password, role) VALUES ('carlos.123@gmail.com','Carlos', 'carlos123', null);

INSERT INTO tb_movie(score, count, title, image) VALUES (0.0, 1, 'O Rei Macaco', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bmwK5QCznqUT8bcDR7qROrxqgov.jpg');

INSERT INTO tb_score(movie_id, user_id, value) VALUES (1, 1, 0.0);