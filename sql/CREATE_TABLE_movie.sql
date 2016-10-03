-- Table: public.movie

-- DROP TABLE public.movie;

CREATE TABLE public.movie
(
    id text COLLATE "default".pg_catalog NOT NULL,
    name text COLLATE "default".pg_catalog,
    dt date,
    tm time without time zone,
    path text COLLATE "default".pg_catalog,
    CONSTRAINT movie_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.movie
    OWNER to postgres;