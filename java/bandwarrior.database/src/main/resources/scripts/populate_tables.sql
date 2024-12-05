-- Inserindo usuários
INSERT INTO "user" (login, pwd, name, description, firstlogin, createdon, active) 
VALUES
    ('admin', 'senha_admin', 'Admin', 'Administrador do sistema', TRUE, CURRENT_TIMESTAMP, TRUE),
    ('joao', 'senha_joao', 'João', 'Membro da banda Letz Bossa', TRUE, CURRENT_TIMESTAMP, TRUE),
    ('thomas', 'senha_thomas', 'Thomas', 'Membro da banda Letz Bossa', TRUE, CURRENT_TIMESTAMP, TRUE),
    ('manu', 'senha_manu', 'Manu', 'Membro da banda Letz Bossa', TRUE, CURRENT_TIMESTAMP, TRUE),
    ('mario', 'senha_mario', 'Mario', 'Membro da banda Marios Band', TRUE, CURRENT_TIMESTAMP, TRUE),
    ('luiggi', 'senha_luiggi', 'Luiggi', 'Membro da banda Marios Band', TRUE, CURRENT_TIMESTAMP, TRUE);
-- Inserindo bandas
INSERT INTO band (name, description, createdon, responsible) 
VALUES
    ('Letz Bossa', 'Banda de bossa nova e jazz', CURRENT_TIMESTAMP, (SELECT id FROM "user" WHERE login = 'joao')),
    ('Marios Band', 'Banda de rock', CURRENT_TIMESTAMP, (SELECT id FROM "user" WHERE login = 'mario'));
-- Inserindo membros na banda Letz Bossa
INSERT INTO band_members (id_band, id_user, description) 
VALUES
    ((SELECT id FROM band WHERE name = 'Letz Bossa'), (SELECT id FROM "user" WHERE login = 'joao'), 'Responsável pela banda'),
    ((SELECT id FROM band WHERE name = 'Letz Bossa'), (SELECT id FROM "user" WHERE login = 'thomas'), 'Membro da banda'),
    ((SELECT id FROM band WHERE name = 'Letz Bossa'), (SELECT id FROM "user" WHERE login = 'manu'), 'Membro da banda');

-- Inserindo membros na banda Marios Band
INSERT INTO band_members (id_band, id_user, description) 
VALUES
    ((SELECT id FROM band WHERE name = 'Marios Band'), (SELECT id FROM "user" WHERE login = 'mario'), 'Responsável pela banda'),
    ((SELECT id FROM band WHERE name = 'Marios Band'), (SELECT id FROM "user" WHERE login = 'luiggi'), 'Membro da banda');
-- Inserindo as solicitações para a banda Letz Bossa
INSERT INTO band_requests (id_band, id_user, message) 
VALUES
    ((SELECT id FROM band WHERE name = 'Letz Bossa'), (SELECT id FROM "user" WHERE login = 'mario'), 'Gostaria de entrar na banda Letz Bossa'),
    ((SELECT id FROM band WHERE name = 'Letz Bossa'), (SELECT id FROM "user" WHERE login = 'luiggi'), 'Gostaria de entrar na banda Letz Bossa');
