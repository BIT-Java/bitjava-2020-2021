package pl.edu.knbit.bitjava;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by surja on 31.10.2020
 */
public class Main {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
//        System.out.println(empty.isEmpty());
//
        String name = "bitJava";
        Optional<String> opt = Optional.of(name);
//        System.out.println(opt.isPresent());

        String nullable = null;
//        Optional<String> optional = Optional.of(nullable); // NPE!!!

        Optional<String> nullOptional = Optional.ofNullable(nullable);
//        System.out.println(nullOptional.isPresent());

        Optional<String> optional = Optional.ofNullable("Bit-Java");
//        System.out.println(optional.isPresent());
//          //IF PRESENT
//        if(optional.isPresent()){
//            String s = optional.get();
//            System.out.println(s);
//        }
//        optional.ifPresent(s -> System.out.println(s.toLowerCase()));
//        nullOptional.ifPresent(s -> System.out.println(s.toLowerCase()));
//          //OR Else

//        String s = nullOptional.get();
//        String s = nullOptional.orElse("Ala ma kota");
//        String s = optional.orElse("Ala ma kota");
//        System.out.println(s);

        //
//          // ORElseGet
//        String s = optional.orElseGet(() -> getDefault());
//        String s2 = nullOptional.orElseGet(() -> getDefault());

//        System.out.println(s);

//String s = nullOptional.orElse(getDefault());
//        String s = optional.orElse(getDefault());
//        System.out.println(s);




        //OrElseThrow
//        String s3 = nullOptional.orElseThrow();


//         //get
//        String s1 = nullOptional.get();

        if(nullOptional.isPresent()){
            nullOptional.get();
        }

//        String s = optional.get();
//




//        //filter
//        boolean present = optional.filter(s -> s.equals("Bit-Java")).isPresent();
//        System.out.println(present);




//        //map
        User user = new User("Mateusz", 21);
        Optional.ofNullable(user).map(u -> u.age).filter(integer -> integer > 22).isPresent();
//
//        if(user!=null){
//            if(user.age > 22) {
//                //true
//            }
//        }
//
//        System.out.println(user.address.street);
//
//        user.setAddress(new Address("ccc"));
        String s = Optional.ofNullable(user).map(user1 -> user1.address).map(a -> a.street).orElse("");
//        System.out.println(s);
//
//
//
//
//        //FlatMap
        String s1 = Optional.ofNullable(user).flatMap(u -> u.getAddress()).map(address -> address.street).orElse("");
//        System.out.println(s1);
//
        Optional.ofNullable(user).flatMap(u -> u.getAddress()).map(a -> a.street).orElseThrow(IllegalArgumentException::new);

    }

    private static String getDefault() {
        System.out.println("Getting default");
        return "Default";
    }
}
