
// Enums can also have abstract methods and that need to be 
// implemented by all the enum members
// If we forget to implement even for one then compile time errors.

// The enums can also override/overload the methods defined in the enum class
// They follow all the rules of overriding and overloading. 

// even they can have public methods
public enum JavaAbstractEnums {
    
    WINTER {
        public String getHours() {
            return "8:00 AM - 6:00 AM";
        }

        public String light() {
            return "Low";
        }
    },
    SUMER {
        public String getHours() {
            return "6:00 AM - 8:00 AM";
        }

        public String light() {
            return "High";
        }

        // COMPILE TIME ERROR - Cannot override final method
        // public String feeling() {
        //     return "HOT";
        // }

        // perfeclty fine, we have overloaded it now for SUMER
        public String feeling( String mood ) {
            return mood;
        }
    },
    SPRING {
        public String getHours() {
            return "7:00 AM - 7:00 AM";
        }

        // COMPILE TIME ERROR
        // Overriding rules gets kicked here
        // private String light() {
        //     return "GOOD";
        // }
    },
    FALL {
        public String getHours() {
            return "8:00 AM - 7:00 AM";
        }
    };

    public abstract String getHours();

    public String light() {
        return "So-So";
    }

    public final String feeling() {
        return "Exceptional";
    }
}
