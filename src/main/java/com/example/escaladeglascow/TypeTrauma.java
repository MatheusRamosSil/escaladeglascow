package com.example.escaladeglascow;

public enum TypeTrauma {
    LEVE{

        @Override
        public String doTypeTrauma(int resultDosTestes) {
            if(resultDosTestes > 12 && resultDosTestes < 16){
                return "LEVE";
            }
            return "Valor não encotrado";
        }
    },
    
    MODERADO{

        @Override
        public String doTypeTrauma(int resultDosTestes) {
            if(resultDosTestes >= 9 && resultDosTestes <= 12){
                return "MODERADO";
            }
            return null;
        }


    },

    GRAVE{


        @Override
        public String doTypeTrauma(int resultDosTestes) {
            if(resultDosTestes >=3  && resultDosTestes < 9){
                return "GRAVE";
            }
            return "não sei";
        }
    };

    public abstract String doTypeTrauma(int resultDosTestes);
}
