PGDMP     9                 
    w         
   hulk_store    10.6    10.6 >    6           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            7           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            8           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            9           1262    49346 
   hulk_store    DATABASE     �   CREATE DATABASE hulk_store WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Mexico.1252' LC_CTYPE = 'Spanish_Mexico.1252';
    DROP DATABASE hulk_store;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            :           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            ;           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    49423    empleado    TABLE       CREATE TABLE public.empleado (
    emp_id integer NOT NULL,
    emp_codigo character varying(45) NOT NULL,
    emp_nombres character varying(50) NOT NULL,
    emp_apellidos character varying(50) NOT NULL,
    emp_identificacion character varying(20) NOT NULL
);
    DROP TABLE public.empleado;
       public         postgres    false    3            �            1259    49421    empleado_emp_id_seq    SEQUENCE     �   CREATE SEQUENCE public.empleado_emp_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.empleado_emp_id_seq;
       public       postgres    false    209    3            <           0    0    empleado_emp_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.empleado_emp_id_seq OWNED BY public.empleado.emp_id;
            public       postgres    false    208            �            1259    49357    marca    TABLE     �   CREATE TABLE public.marca (
    mar_id integer NOT NULL,
    mar_nombre character varying(45) NOT NULL,
    mar_descripcion character varying(100) NOT NULL,
    mar_estado integer NOT NULL
);
    DROP TABLE public.marca;
       public         postgres    false    3            �            1259    49355    marca_mar_id_seq    SEQUENCE     �   CREATE SEQUENCE public.marca_mar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.marca_mar_id_seq;
       public       postgres    false    199    3            =           0    0    marca_mar_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.marca_mar_id_seq OWNED BY public.marca.mar_id;
            public       postgres    false    198            �            1259    49391 
   movimiento    TABLE     �   CREATE TABLE public.movimiento (
    mov_id integer NOT NULL,
    tim_id integer NOT NULL,
    mov_fecha_hora timestamp without time zone DEFAULT now(),
    emp_id integer NOT NULL
);
    DROP TABLE public.movimiento;
       public         postgres    false    3            �            1259    49405    movimiento_detalle    TABLE     �   CREATE TABLE public.movimiento_detalle (
    mde_id integer NOT NULL,
    mov_id integer NOT NULL,
    prod_id integer NOT NULL,
    mde_cantidad integer NOT NULL
);
 &   DROP TABLE public.movimiento_detalle;
       public         postgres    false    3            �            1259    49403    movimiento_detalle_mde_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movimiento_detalle_mde_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.movimiento_detalle_mde_id_seq;
       public       postgres    false    207    3            >           0    0    movimiento_detalle_mde_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.movimiento_detalle_mde_id_seq OWNED BY public.movimiento_detalle.mde_id;
            public       postgres    false    206            �            1259    49389    movimiento_mov_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movimiento_mov_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.movimiento_mov_id_seq;
       public       postgres    false    205    3            ?           0    0    movimiento_mov_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.movimiento_mov_id_seq OWNED BY public.movimiento.mov_id;
            public       postgres    false    204            �            1259    49365    producto    TABLE     R  CREATE TABLE public.producto (
    prod_id integer NOT NULL,
    prod_codigo character varying(45) NOT NULL,
    tip_id integer NOT NULL,
    prod_nombre character varying(50) NOT NULL,
    prod_descripcion character varying(100) NOT NULL,
    prod_stock integer NOT NULL,
    prod_estado integer NOT NULL,
    mar_id integer NOT NULL
);
    DROP TABLE public.producto;
       public         postgres    false    3            �            1259    49363    producto_prod_id_seq    SEQUENCE     �   CREATE SEQUENCE public.producto_prod_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.producto_prod_id_seq;
       public       postgres    false    3    201            @           0    0    producto_prod_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.producto_prod_id_seq OWNED BY public.producto.prod_id;
            public       postgres    false    200            �            1259    49383    tipo_movimiento    TABLE     �   CREATE TABLE public.tipo_movimiento (
    tim_id integer NOT NULL,
    tim_nombre character varying(50) NOT NULL,
    tim_estado character varying(45) NOT NULL
);
 #   DROP TABLE public.tipo_movimiento;
       public         postgres    false    3            �            1259    49381    tipo_movimiento_tim_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_movimiento_tim_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.tipo_movimiento_tim_id_seq;
       public       postgres    false    3    203            A           0    0    tipo_movimiento_tim_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.tipo_movimiento_tim_id_seq OWNED BY public.tipo_movimiento.tim_id;
            public       postgres    false    202            �            1259    49349    tipo_producto    TABLE     �   CREATE TABLE public.tipo_producto (
    tip_id integer NOT NULL,
    tip_nombre character varying(50) NOT NULL,
    tip_descripcion character varying(100) NOT NULL,
    tip_estado integer NOT NULL
);
 !   DROP TABLE public.tipo_producto;
       public         postgres    false    3            �            1259    49347    tipo_producto_tip_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_producto_tip_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tipo_producto_tip_id_seq;
       public       postgres    false    197    3            B           0    0    tipo_producto_tip_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.tipo_producto_tip_id_seq OWNED BY public.tipo_producto.tip_id;
            public       postgres    false    196            �
           2604    49426    empleado emp_id    DEFAULT     r   ALTER TABLE ONLY public.empleado ALTER COLUMN emp_id SET DEFAULT nextval('public.empleado_emp_id_seq'::regclass);
 >   ALTER TABLE public.empleado ALTER COLUMN emp_id DROP DEFAULT;
       public       postgres    false    208    209    209            �
           2604    49360    marca mar_id    DEFAULT     l   ALTER TABLE ONLY public.marca ALTER COLUMN mar_id SET DEFAULT nextval('public.marca_mar_id_seq'::regclass);
 ;   ALTER TABLE public.marca ALTER COLUMN mar_id DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    49394    movimiento mov_id    DEFAULT     v   ALTER TABLE ONLY public.movimiento ALTER COLUMN mov_id SET DEFAULT nextval('public.movimiento_mov_id_seq'::regclass);
 @   ALTER TABLE public.movimiento ALTER COLUMN mov_id DROP DEFAULT;
       public       postgres    false    204    205    205            �
           2604    49408    movimiento_detalle mde_id    DEFAULT     �   ALTER TABLE ONLY public.movimiento_detalle ALTER COLUMN mde_id SET DEFAULT nextval('public.movimiento_detalle_mde_id_seq'::regclass);
 H   ALTER TABLE public.movimiento_detalle ALTER COLUMN mde_id DROP DEFAULT;
       public       postgres    false    206    207    207            �
           2604    49368    producto prod_id    DEFAULT     t   ALTER TABLE ONLY public.producto ALTER COLUMN prod_id SET DEFAULT nextval('public.producto_prod_id_seq'::regclass);
 ?   ALTER TABLE public.producto ALTER COLUMN prod_id DROP DEFAULT;
       public       postgres    false    200    201    201            �
           2604    49386    tipo_movimiento tim_id    DEFAULT     �   ALTER TABLE ONLY public.tipo_movimiento ALTER COLUMN tim_id SET DEFAULT nextval('public.tipo_movimiento_tim_id_seq'::regclass);
 E   ALTER TABLE public.tipo_movimiento ALTER COLUMN tim_id DROP DEFAULT;
       public       postgres    false    203    202    203            �
           2604    49352    tipo_producto tip_id    DEFAULT     |   ALTER TABLE ONLY public.tipo_producto ALTER COLUMN tip_id SET DEFAULT nextval('public.tipo_producto_tip_id_seq'::regclass);
 C   ALTER TABLE public.tipo_producto ALTER COLUMN tip_id DROP DEFAULT;
       public       postgres    false    196    197    197            3          0    49423    empleado 
   TABLE DATA               f   COPY public.empleado (emp_id, emp_codigo, emp_nombres, emp_apellidos, emp_identificacion) FROM stdin;
    public       postgres    false    209   �F       )          0    49357    marca 
   TABLE DATA               P   COPY public.marca (mar_id, mar_nombre, mar_descripcion, mar_estado) FROM stdin;
    public       postgres    false    199   �F       /          0    49391 
   movimiento 
   TABLE DATA               L   COPY public.movimiento (mov_id, tim_id, mov_fecha_hora, emp_id) FROM stdin;
    public       postgres    false    205   \G       1          0    49405    movimiento_detalle 
   TABLE DATA               S   COPY public.movimiento_detalle (mde_id, mov_id, prod_id, mde_cantidad) FROM stdin;
    public       postgres    false    207   H       +          0    49365    producto 
   TABLE DATA               �   COPY public.producto (prod_id, prod_codigo, tip_id, prod_nombre, prod_descripcion, prod_stock, prod_estado, mar_id) FROM stdin;
    public       postgres    false    201   �H       -          0    49383    tipo_movimiento 
   TABLE DATA               I   COPY public.tipo_movimiento (tim_id, tim_nombre, tim_estado) FROM stdin;
    public       postgres    false    203   �I       '          0    49349    tipo_producto 
   TABLE DATA               X   COPY public.tipo_producto (tip_id, tip_nombre, tip_descripcion, tip_estado) FROM stdin;
    public       postgres    false    197   J       C           0    0    empleado_emp_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.empleado_emp_id_seq', 1, true);
            public       postgres    false    208            D           0    0    marca_mar_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.marca_mar_id_seq', 3, true);
            public       postgres    false    198            E           0    0    movimiento_detalle_mde_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.movimiento_detalle_mde_id_seq', 24, true);
            public       postgres    false    206            F           0    0    movimiento_mov_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.movimiento_mov_id_seq', 15, true);
            public       postgres    false    204            G           0    0    producto_prod_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.producto_prod_id_seq', 10, true);
            public       postgres    false    200            H           0    0    tipo_movimiento_tim_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.tipo_movimiento_tim_id_seq', 2, true);
            public       postgres    false    202            I           0    0    tipo_producto_tip_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tipo_producto_tip_id_seq', 5, true);
            public       postgres    false    196            �
           2606    49428    empleado empleado_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (emp_id);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public         postgres    false    209            �
           2606    49362    marca marca_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (mar_id);
 :   ALTER TABLE ONLY public.marca DROP CONSTRAINT marca_pkey;
       public         postgres    false    199            �
           2606    49410 *   movimiento_detalle movimiento_detalle_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.movimiento_detalle
    ADD CONSTRAINT movimiento_detalle_pkey PRIMARY KEY (mde_id);
 T   ALTER TABLE ONLY public.movimiento_detalle DROP CONSTRAINT movimiento_detalle_pkey;
       public         postgres    false    207            �
           2606    49397    movimiento movimiento_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (mov_id);
 D   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT movimiento_pkey;
       public         postgres    false    205            �
           2606    49370    producto producto_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (prod_id);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public         postgres    false    201            �
           2606    49388 $   tipo_movimiento tipo_movimiento_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tipo_movimiento
    ADD CONSTRAINT tipo_movimiento_pkey PRIMARY KEY (tim_id);
 N   ALTER TABLE ONLY public.tipo_movimiento DROP CONSTRAINT tipo_movimiento_pkey;
       public         postgres    false    203            �
           2606    49354     tipo_producto tipo_producto_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tipo_producto
    ADD CONSTRAINT tipo_producto_pkey PRIMARY KEY (tip_id);
 J   ALTER TABLE ONLY public.tipo_producto DROP CONSTRAINT tipo_producto_pkey;
       public         postgres    false    197            �
           2606    49411 1   movimiento_detalle movimiento_detalle_mov_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimiento_detalle
    ADD CONSTRAINT movimiento_detalle_mov_id_fkey FOREIGN KEY (mov_id) REFERENCES public.movimiento(mov_id);
 [   ALTER TABLE ONLY public.movimiento_detalle DROP CONSTRAINT movimiento_detalle_mov_id_fkey;
       public       postgres    false    207    2723    205            �
           2606    49416 2   movimiento_detalle movimiento_detalle_prod_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimiento_detalle
    ADD CONSTRAINT movimiento_detalle_prod_id_fkey FOREIGN KEY (prod_id) REFERENCES public.producto(prod_id);
 \   ALTER TABLE ONLY public.movimiento_detalle DROP CONSTRAINT movimiento_detalle_prod_id_fkey;
       public       postgres    false    2719    207    201            �
           2606    49398 !   movimiento movimiento_tim_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_tim_id_fkey FOREIGN KEY (tim_id) REFERENCES public.tipo_movimiento(tim_id);
 K   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT movimiento_tim_id_fkey;
       public       postgres    false    203    205    2721            �
           2606    49376    producto producto_mar_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_mar_id_fkey FOREIGN KEY (mar_id) REFERENCES public.marca(mar_id);
 G   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_mar_id_fkey;
       public       postgres    false    199    2717    201            �
           2606    49371    producto producto_tip_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_tip_id_fkey FOREIGN KEY (tip_id) REFERENCES public.tipo_producto(tip_id);
 G   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_tip_id_fkey;
       public       postgres    false    201    197    2715            3   6   x�3�44075�01�4��	�V�p�s��t���vT��q�Hʸb���� v&�      )   [   x�3��u
s���w	u�WpqU�qT �:;��������
PU�\F�.΄Ursy�~�.�.��A��.�
�A }�\1z\\\ ��"      /   �   x�m��� �s�"�შP��_�BN��3ޞ_���!�����
��A�\�4y]��#��SuS�Gb�QC'M���S�����a:H�R�'f�E�;�v]����|��!�L��>��Yre�{h`g�:������|�fݲ&!A��
W�!N�g�����6W�������P�      1   x   x�%�Q!C���lAǻ��ϱ�#<���d��r�"K��Ƽ�¼�FY��2��!P�XR���D1&���౧�K��#E)��>Z��9L^�j)�H��S,��IA������      +   -  x��RMO�@=���9�a�.P���e�(U�(1&Z0��.J����כ�fv�e>
����e�:���l �1}�4��$���� /D�s��ޤ�M
�Hz'��'��-�2B:�;z�����+�������G��Gg��˝iHg2+J3�L�(������(����<%�X߶�y۰���Ԍ� V��r�a�{�'�'��ï��A�;��m��k��ZP˥�_���&s�QZ�%[�z@q2��d�PA�\�=�����l��aE��@�oS�j�}����t�1_a��y����ꢄ      -       x�3�t�	rtq�4�2�v��3c���� US      '   L   x�3�tv��vq�3�9��8���!�!�1�����3�4�2��
uuq�ӆ\����ή��A��H,C�=... �r�     