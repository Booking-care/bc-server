CREATE TABLE public.all_codes (
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    id uuid NOT NULL,
    key character varying(255),
    type character varying(255),
    value_en character varying(255),
    value_vi character varying(255)
);


ALTER TABLE public.all_codes OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 215 (class 1259 OID 17294)
-- Name: bookings; Type: TABLE; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

CREATE TABLE public.bookings (
    created_at timestamp(6) without time zone,
    date timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    doctor_id uuid,
    id uuid NOT NULL,
    patient_id uuid,
    status_id character varying(255),
    time_type character varying(255)
);


ALTER TABLE public.bookings OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 216 (class 1259 OID 17301)
-- Name: clinics; Type: TABLE; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

CREATE TABLE public.clinics (
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    id uuid NOT NULL,
    address character varying(255),
    description text,
    image character varying(255),
    name character varying(255)
);


ALTER TABLE public.clinics OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 217 (class 1259 OID 17308)
-- Name: histories; Type: TABLE; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

CREATE TABLE public.histories (
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    doctor_id uuid,
    id uuid NOT NULL,
    patient_id uuid,
    description text,
    files text[]
);


ALTER TABLE public.histories OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 218 (class 1259 OID 17315)
-- Name: schedules; Type: TABLE; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

CREATE TABLE public.schedules (
    current_number integer NOT NULL,
    max_number integer NOT NULL,
    created_at timestamp(6) without time zone,
    date timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    doctor_id uuid,
    id uuid NOT NULL,
    time_type character varying(255)
);


ALTER TABLE public.schedules OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 219 (class 1259 OID 17320)
-- Name: specialties; Type: TABLE; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

CREATE TABLE public.specialties (
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    id uuid NOT NULL,
    description text,
    image character varying(255),
    name character varying(255)
);


ALTER TABLE public.specialties OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 220 (class 1259 OID 17327)
-- Name: users; Type: TABLE; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

CREATE TABLE public.users (
    gender boolean NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    clinic_id uuid,
    id uuid NOT NULL,
    position_id uuid,
    role_id uuid,
    specialty_id uuid,
    address character varying(255),
    email character varying(255),
    first_name character varying(255),
    image character varying(255),
    last_name character varying(255),
    password character varying(255),
    phone_number character varying(255)
);


ALTER TABLE public.users OWNER TO "zNxpWKYn0RXphr0";

--
-- TOC entry 3261 (class 2606 OID 17293)
-- Name: all_codes all_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.all_codes
    ADD CONSTRAINT all_codes_pkey PRIMARY KEY (id);


--
-- TOC entry 3263 (class 2606 OID 17300)
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (id);


--
-- TOC entry 3265 (class 2606 OID 17307)
-- Name: clinics clinics_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.clinics
    ADD CONSTRAINT clinics_pkey PRIMARY KEY (id);


--
-- TOC entry 3267 (class 2606 OID 17314)
-- Name: histories histories_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.histories
    ADD CONSTRAINT histories_pkey PRIMARY KEY (id);


--
-- TOC entry 3269 (class 2606 OID 17319)
-- Name: schedules schedules_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.schedules
    ADD CONSTRAINT schedules_pkey PRIMARY KEY (id);


--
-- TOC entry 3271 (class 2606 OID 17326)
-- Name: specialties specialties_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.specialties
    ADD CONSTRAINT specialties_pkey PRIMARY KEY (id);


--
-- TOC entry 3273 (class 2606 OID 17333)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3279 (class 2606 OID 17364)
-- Name: users fk8im9de3p7o1o1di4b14gxvu6p; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk8im9de3p7o1o1di4b14gxvu6p FOREIGN KEY (position_id) REFERENCES public.all_codes(id);


--
-- TOC entry 3280 (class 2606 OID 17359)
-- Name: users fkdtr2ppiyhryd53ovem6c4ehp1; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkdtr2ppiyhryd53ovem6c4ehp1 FOREIGN KEY (clinic_id) REFERENCES public.clinics(id);


--
-- TOC entry 3276 (class 2606 OID 17344)
-- Name: histories fkfi766aev7es5loll73ldh7co9; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.histories
    ADD CONSTRAINT fkfi766aev7es5loll73ldh7co9 FOREIGN KEY (doctor_id) REFERENCES public.users(id);


--
-- TOC entry 3281 (class 2606 OID 17369)
-- Name: users fkhecyyxshavymu8nsru50m7sjs; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkhecyyxshavymu8nsru50m7sjs FOREIGN KEY (role_id) REFERENCES public.all_codes(id);


--
-- TOC entry 3278 (class 2606 OID 17354)
-- Name: schedules fkhh7q3ryrcnpun7i6w37ckx71v; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.schedules
    ADD CONSTRAINT fkhh7q3ryrcnpun7i6w37ckx71v FOREIGN KEY (doctor_id) REFERENCES public.users(id);


--
-- TOC entry 3282 (class 2606 OID 17374)
-- Name: users fkih74rpug03pac4o5mqt12j9cl; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkih74rpug03pac4o5mqt12j9cl FOREIGN KEY (specialty_id) REFERENCES public.specialties(id);


--
-- TOC entry 3277 (class 2606 OID 17349)
-- Name: histories fkjq70c4a0bshm6dmafand7v0dr; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.histories
    ADD CONSTRAINT fkjq70c4a0bshm6dmafand7v0dr FOREIGN KEY (patient_id) REFERENCES public.users(id);


--
-- TOC entry 3274 (class 2606 OID 17339)
-- Name: bookings fkkbu1x71i8rdh64cdqr5mieewk; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT fkkbu1x71i8rdh64cdqr5mieewk FOREIGN KEY (patient_id) REFERENCES public.users(id);


--
-- TOC entry 3275 (class 2606 OID 17334)
-- Name: bookings fkrjdigg8pwko1ircdew8dbge6j; Type: FK CONSTRAINT; Schema: public; Owner: "zNxpWKYn0RXphr0"
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT fkrjdigg8pwko1ircdew8dbge6j FOREIGN KEY (doctor_id) REFERENCES public.users(id);


-- Completed on 2024-05-18 11:07:52 +07

--
-- "zNxpWKYn0RXphr0"QL database dump complete
--

