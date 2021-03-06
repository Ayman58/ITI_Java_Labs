PGDMP                          z            MyITI    14.0    14.0 +    ,           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            -           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            .           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            /           1262    16491    MyITI    DATABASE     k   CREATE DATABASE "MyITI" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "MyITI";
                postgres    false            ?            1259    16556    accounts    TABLE     %  CREATE TABLE public.accounts (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    created_on timestamp without time zone NOT NULL,
    last_login timestamp without time zone
);
    DROP TABLE public.accounts;
       public         heap    postgres    false            ?            1259    16555    accounts_user_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.accounts_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.accounts_user_id_seq;
       public          postgres    false    215            0           0    0    accounts_user_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.accounts_user_id_seq OWNED BY public.accounts.user_id;
          public          postgres    false    214            ?            1259    16581    contact    TABLE     ?   CREATE TABLE public.contact (
    id integer NOT NULL,
    first_name character varying,
    middle_name character varying,
    "last_name             " character varying,
    email character varying,
    phone integer
);
    DROP TABLE public.contact;
       public         heap    postgres    false            ?            1259    16566    contacts    TABLE     ?   CREATE TABLE public.contacts (
    id integer NOT NULL,
    first_name character varying,
    middle_name character varying,
    last_name character varying,
    email character varying,
    phone integer
);
    DROP TABLE public.contacts;
       public         heap    postgres    false            ?            1259    16492    departments    TABLE     ?   CREATE TABLE public.departments (
    dname character varying(50),
    dnum integer NOT NULL,
    mgrssn integer,
    "MGRStart Date" date
);
    DROP TABLE public.departments;
       public         heap    postgres    false            ?            1259    16495 	   dependent    TABLE     ?   CREATE TABLE public.dependent (
    essn integer NOT NULL,
    dependent_name character varying(255) NOT NULL,
    sex character varying(255),
    bdate timestamp with time zone
);
    DROP TABLE public.dependent;
       public         heap    postgres    false            ?            1259    16500    employee    TABLE       CREATE TABLE public.employee (
    fname character varying(50),
    lname character varying(50),
    ssn integer NOT NULL,
    bdate timestamp with time zone,
    address character varying(50),
    sex character varying(50),
    salary integer,
    superssn integer,
    dno integer
);
    DROP TABLE public.employee;
       public         heap    postgres    false            ?            1259    16503    project    TABLE     ?   CREATE TABLE public.project (
    pname character varying(50),
    pnumber integer NOT NULL,
    plocation character varying(50),
    city character varying(50),
    dnum integer
);
    DROP TABLE public.project;
       public         heap    postgres    false            ?            1259    16506 	   works_for    TABLE     j   CREATE TABLE public.works_for (
    essn integer NOT NULL,
    pno integer NOT NULL,
    hours integer
);
    DROP TABLE public.works_for;
       public         heap    postgres    false            x           2604    16559    accounts user_id    DEFAULT     t   ALTER TABLE ONLY public.accounts ALTER COLUMN user_id SET DEFAULT nextval('public.accounts_user_id_seq'::regclass);
 ?   ALTER TABLE public.accounts ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    214    215    215            '          0    16556    accounts 
   TABLE DATA           ^   COPY public.accounts (user_id, username, password, email, created_on, last_login) FROM stdin;
    public          postgres    false    215   H1       )          0    16581    contact 
   TABLE DATA           f   COPY public.contact (id, first_name, middle_name, "last_name             ", email, phone) FROM stdin;
    public          postgres    false    217   e1       (          0    16566    contacts 
   TABLE DATA           X   COPY public.contacts (id, first_name, middle_name, last_name, email, phone) FROM stdin;
    public          postgres    false    216   ?1       !          0    16492    departments 
   TABLE DATA           K   COPY public.departments (dname, dnum, mgrssn, "MGRStart Date") FROM stdin;
    public          postgres    false    209   Q2       "          0    16495 	   dependent 
   TABLE DATA           E   COPY public.dependent (essn, dependent_name, sex, bdate) FROM stdin;
    public          postgres    false    210   ?2       #          0    16500    employee 
   TABLE DATA           a   COPY public.employee (fname, lname, ssn, bdate, address, sex, salary, superssn, dno) FROM stdin;
    public          postgres    false    211   ?3       $          0    16503    project 
   TABLE DATA           H   COPY public.project (pname, pnumber, plocation, city, dnum) FROM stdin;
    public          postgres    false    212   -5       %          0    16506 	   works_for 
   TABLE DATA           5   COPY public.works_for (essn, pno, hours) FROM stdin;
    public          postgres    false    213   ?5       1           0    0    accounts_user_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.accounts_user_id_seq', 1, false);
          public          postgres    false    214            ?           2606    16565    accounts accounts_email_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_email_key UNIQUE (email);
 E   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_email_key;
       public            postgres    false    215            ?           2606    16561    accounts accounts_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    215            ?           2606    16563    accounts accounts_username_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_username_key UNIQUE (username);
 H   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_username_key;
       public            postgres    false    215            ?           2606    16587    contact contact_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.contact DROP CONSTRAINT contact_pkey;
       public            postgres    false    217            ?           2606    16580    contacts contacts _pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT "contacts _pkey" PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.contacts DROP CONSTRAINT "contacts _pkey";
       public            postgres    false    216            z           2606    16510    departments pk_departments 
   CONSTRAINT     Z   ALTER TABLE ONLY public.departments
    ADD CONSTRAINT pk_departments PRIMARY KEY (dnum);
 D   ALTER TABLE ONLY public.departments DROP CONSTRAINT pk_departments;
       public            postgres    false    209            }           2606    16512    dependent pk_dependant 
   CONSTRAINT     f   ALTER TABLE ONLY public.dependent
    ADD CONSTRAINT pk_dependant PRIMARY KEY (essn, dependent_name);
 @   ALTER TABLE ONLY public.dependent DROP CONSTRAINT pk_dependant;
       public            postgres    false    210    210                       2606    16514    employee pk_employee 
   CONSTRAINT     S   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT pk_employee PRIMARY KEY (ssn);
 >   ALTER TABLE ONLY public.employee DROP CONSTRAINT pk_employee;
       public            postgres    false    211            ?           2606    16516    project pk_project 
   CONSTRAINT     U   ALTER TABLE ONLY public.project
    ADD CONSTRAINT pk_project PRIMARY KEY (pnumber);
 <   ALTER TABLE ONLY public.project DROP CONSTRAINT pk_project;
       public            postgres    false    212            ?           2606    16518    works_for pk_works_for 
   CONSTRAINT     [   ALTER TABLE ONLY public.works_for
    ADD CONSTRAINT pk_works_for PRIMARY KEY (essn, pno);
 @   ALTER TABLE ONLY public.works_for DROP CONSTRAINT pk_works_for;
       public            postgres    false    213    213            {           1259    16519    fki_fk_dependent    INDEX     F   CREATE INDEX fki_fk_dependent ON public.dependent USING btree (essn);
 $   DROP INDEX public.fki_fk_dependent;
       public            postgres    false    210            ?           1259    16520    fki_fk_project    INDEX     B   CREATE INDEX fki_fk_project ON public.project USING btree (dnum);
 "   DROP INDEX public.fki_fk_project;
       public            postgres    false    212            ?           1259    16521    fki_fk_works_for    INDEX     E   CREATE INDEX fki_fk_works_for ON public.works_for USING btree (pno);
 $   DROP INDEX public.fki_fk_works_for;
       public            postgres    false    213            ?           1259    16522    fki_fk_works_for_2    INDEX     H   CREATE INDEX fki_fk_works_for_2 ON public.works_for USING btree (essn);
 &   DROP INDEX public.fki_fk_works_for_2;
       public            postgres    false    213            ?           2606    16523    dependent fk_dependent    FK CONSTRAINT     ?   ALTER TABLE ONLY public.dependent
    ADD CONSTRAINT fk_dependent FOREIGN KEY (essn) REFERENCES public.employee(ssn) NOT VALID;
 @   ALTER TABLE ONLY public.dependent DROP CONSTRAINT fk_dependent;
       public          postgres    false    211    210    3199            ?           2606    16528    employee fk_employee    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk_employee FOREIGN KEY (superssn) REFERENCES public.employee(ssn) NOT VALID;
 >   ALTER TABLE ONLY public.employee DROP CONSTRAINT fk_employee;
       public          postgres    false    211    211    3199            ?           2606    16533    project fk_project    FK CONSTRAINT     ?   ALTER TABLE ONLY public.project
    ADD CONSTRAINT fk_project FOREIGN KEY (dnum) REFERENCES public.departments(dnum) NOT VALID;
 <   ALTER TABLE ONLY public.project DROP CONSTRAINT fk_project;
       public          postgres    false    3194    209    212            ?           2606    16538    works_for fk_works_for    FK CONSTRAINT     ?   ALTER TABLE ONLY public.works_for
    ADD CONSTRAINT fk_works_for FOREIGN KEY (pno) REFERENCES public.project(pnumber) NOT VALID;
 @   ALTER TABLE ONLY public.works_for DROP CONSTRAINT fk_works_for;
       public          postgres    false    212    213    3202            ?           2606    16543    works_for fk_works_for_2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.works_for
    ADD CONSTRAINT fk_works_for_2 FOREIGN KEY (essn) REFERENCES public.employee(ssn) NOT VALID;
 B   ALTER TABLE ONLY public.works_for DROP CONSTRAINT fk_works_for_2;
       public          postgres    false    3199    213    211            '      x?????? ? ?      )   P   x?3?L??M???L*J?LL?J??J??4421?2B?????L??MM?̋??Z8T&f???%????[Z[p??qqq fN?      (   |   x???M
?@@?ur???L4?t???0??q?۷c?Bq???? ??t???j.????᪭?G??????x??)??
?gmxY???_NĂ	?j?n???<2?i?noa??v3?t?8??L?      !   D   x?Eɱ?0D???%p@??x???G?K??zsL?NF?U?R?d.??[O?j*?<?J?!"?C??      "   ?   x?m?=k?@???W?T$?G?n????.??g?e0??9?K?W?D?l?:? ???ܙz?է?j?@e??v?z?Ω:?"?%??F?/?jJ?: Z??V??F1uW?K?[K<??O	??S?$??)?S?2?v)???%?^9p?⭌"?K???S?n?????.X?3?b???? ?[??B??Y??!c9 + ?d?޴?w??V?      #   ?  x?]?Ok?0???O?{Q?K??f?t!)l????kQ?ZdCH>???6Y?`??޼Q?mU?AJ?????BR1!~,? H??{?n??Ӽ????ZH????v8"?)???ҹ??+4??r??%????پ?޿???3?	͞?y???<????\??qh{8?????+?T???0j|;2?C??^?,I}?IA+i͢P^?????,?????k?s??}?z??X???H?m?3?(??H?۔o??(?t+?Ly Nl?3????????|?[5w?Zd?C!????PW'????r?W?w??gӼ9u??x?
?:[???=Pт?Z??IT?%Y????ud??0␸ly?P?5?ّ?u?ا????
h{?X?e|
#?????ۃ???_7Y??$`??      $   ?   x?e?K
?0??ur?9?Ԫu]Ju㋺A&M4m5P???6Rw?|3????*??!?bE"Cj?-??
?Z'??i??U?*????wʴ???Ŗ?8?N?\?? ?\ǻ?So?Ի:Gf,*?bv??73?jy"_ZX??JlD?l??H?PC>???ŚEA?#t???u&?? ?JN      %   _   x?]?K? ?u9Lßz???U??&??E??"?Yu????????O?????9/??+T*5SUے??
h?X췖?!Y)R? |?'=     