INSERT INTO tb_user(email) VALUES ('maria.123@gmail.com');

INSERT INTO tb_movie(score, count, title, image) VALUES (0, 0, 'O Rei Macaco', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bmwK5QCznqUT8bcDR7qROrxqgov.jpg');
INSERT INTO tb_movie(score, count, title, image) VALUES (0, 0, 'Animais Fantásticos e Onde Habitam', 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/8Qsr8pvDL3s1jNZQ4HK1d1Xlvnh.jpg');

INSERT INTO tb_score(movie_id, user_id, value) VALUES (1, 1, 5.0);