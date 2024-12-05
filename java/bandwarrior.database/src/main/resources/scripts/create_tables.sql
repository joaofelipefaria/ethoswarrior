-- Tabela "user"
CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,  -- Chave primária gerada automaticamente
    login VARCHAR(255) UNIQUE NOT NULL,  -- Login único, não pode ser nulo
    pwd VARCHAR(255) NOT NULL,  -- Senha, não pode ser nula
    name VARCHAR(255) NOT NULL,  -- Nome, não pode ser nulo
    description TEXT,  -- Descrição, pode ser nula
    firstlogin BOOLEAN DEFAULT TRUE,  -- Indica se o usuário é novo, por padrão TRUE
    createdon TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data de criação, por padrão o timestamp atual
    active BOOLEAN DEFAULT TRUE  -- Indica se o usuário está ativo, por padrão TRUE
);

-- Tabela "band"
CREATE TABLE band (
    id SERIAL PRIMARY KEY,  -- Chave primária gerada automaticamente
    name VARCHAR(255) NOT NULL,  -- Nome da banda, não pode ser nulo
    description TEXT,  -- Descrição da banda, pode ser nula
    createdon TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data de criação, por padrão o timestamp atual
    responsible INT NOT NULL,  -- ID do usuário responsável pela banda
    CONSTRAINT fk_responsible FOREIGN KEY (responsible) REFERENCES "user" (id)  -- Chave estrangeira para "user"
);

-- Tabela "band_members"
CREATE TABLE band_members (
    id_band INT NOT NULL,  -- ID da banda
    id_user INT NOT NULL,  -- ID do usuário (membro)
    description TEXT,  -- Descrição, pode ser nula
    PRIMARY KEY (id_band, id_user),  -- Chave primária composta por id_band e id_user
    CONSTRAINT fk_band FOREIGN KEY (id_band) REFERENCES band (id) ON DELETE CASCADE,  -- Chave estrangeira para "band"
    CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES "user" (id) ON DELETE CASCADE  -- Chave estrangeira para "user"
);

-- Tabela "band_requests"
CREATE TABLE band_requests (
    id_band INT NOT NULL,  -- ID da banda
    id_user INT NOT NULL,  -- ID do usuário solicitante
    message TEXT,  -- Mensagem enviada junto com o pedido
    PRIMARY KEY (id_band, id_user),  -- Chave primária composta por id_band e id_user
    CONSTRAINT fk_band_request FOREIGN KEY (id_band) REFERENCES band (id) ON DELETE CASCADE,  -- Chave estrangeira para "band"
    CONSTRAINT fk_user_request FOREIGN KEY (id_user) REFERENCES "user" (id) ON DELETE CASCADE  -- Chave estrangeira para "user"
);