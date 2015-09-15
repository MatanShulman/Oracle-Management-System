CREATE table "INVOICE" (
    "INVOICE_NUM"   NUMBER NOT NULL,
    "ORDER_NUM"     NUMBER NOT NULL,
    "INVOICE_DATE"  DATE NOT NULL,
    "CUSTOMER_NUM"  NUMBER NOT NULL,
    "INVOICE_PRICE" FLOAT NOT NULL,
    constraint  "INVOICE_PK" primary key ("INVOICE_NUM")
)
/

ALTER TABLE "INVOICE" ADD CONSTRAINT "INVOICE_ORDER_FK" 
FOREIGN KEY ("ORDER_NUM")
REFERENCES "ORDERS" ("ORDER_NUM")

/
ALTER TABLE "INVOICE" ADD CONSTRAINT "INVOICE_CUSTOMER_FK" 
FOREIGN KEY ("CUSTOMER_NUM")
REFERENCES "CUSTOMERS" ("CUSTOMER_NUM")

/