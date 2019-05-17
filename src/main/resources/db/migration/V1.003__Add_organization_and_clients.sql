CREATE TABLE organization (
   id           BIGSERIAL PRIMARY KEY,
   name         VARCHAR NOT NULL
);

CREATE TABLE client (
   id           BIGSERIAL PRIMARY KEY,
   name         VARCHAR NOT NULL,
   organization_id BIGINT
);