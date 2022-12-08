package ivan.projects.myshop.entity;

public class Order {

    private Client client;
    private Instrument instrument;


}
//-- Table: public.order_data
//
//        -- DROP TABLE IF EXISTS public.order_data;
//
//        CREATE TABLE IF NOT EXISTS public.order_data
//        (
//        id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
//        order_date timestamp with time zone,
//        client_id bigint NOT NULL,
//        instrument_id bigint NOT NULL,
//        status numeric NOT NULL,
//        CONSTRAINT order_pkey PRIMARY KEY (id),
//        CONSTRAINT client_fkey FOREIGN KEY (client_id)
//        REFERENCES public.client_data (id) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//        NOT VALID,
//        CONSTRAINT instrument_fkey FOREIGN KEY (instrument_id)
//        REFERENCES public.instrument_data (id) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//        NOT VALID
//        )
//
//        TABLESPACE pg_default;
//
//        ALTER TABLE IF EXISTS public.order_data
//        OWNER to postgres;