CREATE TABLE public.usuarios
(
    id integer NOT NULL,
    nome text COLLATE pg_catalog."default" NOT NULL,
    idade integer NOT NULL,
    renda integer,
    disponibilidade integer,
    email text COLLATE pg_catalog."default" NOT NULL,
    sexo character(1) COLLATE pg_catalog."default" NOT NULL,
    senha text COLLATE pg_catalog."default",
    CONSTRAINT "Usuarios_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.usuarios
    OWNER to jtlhjlpycbhkgr;


CREATE TABLE public.tarefas
(
    id integer NOT NULL,
    passo1 boolean,
    passo2 boolean,
    passo3 boolean,
    passo4 boolean,
    passo5 boolean,
    passo6 boolean,
    passo7 boolean,
    passo8 boolean,
    passo9 boolean,
    CONSTRAINT tarefas_pkey PRIMARY KEY (id),
    CONSTRAINT tarefas_id_fkey FOREIGN KEY (id)
        REFERENCES public.usuarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.tarefas
    OWNER to jtlhjlpycbhkgr;