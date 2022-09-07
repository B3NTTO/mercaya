-- Table: rguamantica.mer_cabfact

-- DROP TABLE rguamantica.mer_cabfact;

CREATE TABLE rguamantica.mer_cabfact
(
    cafa_codigo integer NOT NULL DEFAULT nextval('rguamantica.mer_cabfact_cafa_codigo_seq'::regclass),
    prod_codigo integer,
    cafa_empresa character varying(50)[] COLLATE pg_catalog."default",
    clie_codigo integer,
    cafa_fecha timestamp without time zone,
    CONSTRAINT mer_cabfact_pkey PRIMARY KEY (cafa_codigo),
    CONSTRAINT fk_cliente_factura FOREIGN KEY (clie_codigo)
        REFERENCES rguamantica.mer_cliente (clie_codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE rguamantica.mer_cabfact
    OWNER to rguamantica;


-- Table: rguamantica.mer_categoria

-- DROP TABLE rguamantica.mer_categoria;

CREATE TABLE rguamantica.mer_categoria
(
    cate_codigo integer NOT NULL DEFAULT nextval('rguamantica.mer_categoria_cate_codigo_seq'::regclass),
    cate_nombre character varying(25)[] COLLATE pg_catalog."default",
    cate_descrip character varying(150)[] COLLATE pg_catalog."default",
    CONSTRAINT mer_categoria_pkey PRIMARY KEY (cate_codigo)
)

TABLESPACE pg_default;

ALTER TABLE rguamantica.mer_categoria
    OWNER to rguamantica;



-- Table: rguamantica.mer_cliente

-- DROP TABLE rguamantica.mer_cliente;

CREATE TABLE rguamantica.mer_cliente
(
    clie_codigo integer NOT NULL DEFAULT nextval('rguamantica.mer_cliente_clie_codigo_seq'::regclass),
    clie_nombres character varying(50)[] COLLATE pg_catalog."default",
    clie_apellidos character varying(50)[] COLLATE pg_catalog."default",
    clie_direccion character varying(150)[] COLLATE pg_catalog."default",
    clie_telefono character varying(11)[] COLLATE pg_catalog."default",
    clie_correo character varying(100)[] COLLATE pg_catalog."default",
    CONSTRAINT mer_cliente_pkey PRIMARY KEY (clie_codigo)
)

TABLESPACE pg_default;

ALTER TABLE rguamantica.mer_cliente
    OWNER to rguamantica;



-- Table: rguamantica.mer_detfact

-- DROP TABLE rguamantica.mer_detfact;

CREATE TABLE rguamantica.mer_detfact
(
    deta_codigo integer NOT NULL DEFAULT nextval('rguamantica.mer_detfact_deta_codigo_seq'::regclass),
    deta_cantidad numeric,
    cafa_codigo integer,
    cafa_precio numeric,
    cafa_descuento numeric,
    CONSTRAINT mer_detfact_pkey PRIMARY KEY (deta_codigo),
    CONSTRAINT fk_cabecera_detalle_factura FOREIGN KEY (cafa_codigo)
        REFERENCES rguamantica.mer_cabfact (cafa_codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE rguamantica.mer_detfact
    OWNER to rguamantica;

-- Table: rguamantica.mer_producto

-- DROP TABLE rguamantica.mer_producto;

CREATE TABLE rguamantica.mer_producto
(
    prod_codigo integer NOT NULL DEFAULT nextval('rguamantica.mer_producto_prod_codigo_seq'::regclass),
    prod_nombre character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    prod_precio numeric,
    prod_fecelab date,
    prod_fecvenc date,
    cate_codigo integer,
    CONSTRAINT mer_producto_pkey PRIMARY KEY (prod_codigo),
    CONSTRAINT fk_categoria_producto FOREIGN KEY (cate_codigo)
        REFERENCES rguamantica.mer_categoria (cate_codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE rguamantica.mer_producto
    OWNER to rguamantica;