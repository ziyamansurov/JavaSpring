package ownspring.hashing;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class Hashing {
    public  String encrypt(String password ){
        String hashed="";


        for(int i=0;i<password.length();i++){

            String currenthash= String.valueOf(password.charAt(i)+password.hashCode());
            String idk=getEncrypted(currenthash).trim();
            hashed+=idk;

        }


        return hashed.trim();
    }

    public  String getEncrypted(String encrypt){
        String encrypted=" ";
        for(int i=0;i<encrypt.length();i++){

            encrypted+=String.valueOf(Character.toChars(90-Integer.parseInt(String.valueOf(encrypt.charAt(i)))));


        }
        //   System.out.println(encrypted);
        return encrypted;

    }

//    public  String decrypted(String encrypted){
//        String[] arr=encrypted.split(" ");
//        String decrypt="";
//        for(int i=0;i<arr.length;i++){
//
//            if( getDecrypted(arr[i])!=""){
//                decrypt+=String.valueOf(Character.toChars(Integer.parseInt(  getDecrypted(arr[i])) + encrypted.hashCode()));
//
//            }
//            //
////
//
//        }
//
//        return decrypt;
//    }
//    public  String getDecrypted(String encrypt){
//        String decrypted="";
//
//        for(int i=0;i<encrypt.length();i++){
//
//
//            decrypted+=String.valueOf(90-encrypt.charAt(i));
//
//
//
//
//
//        }
//
//        return decrypted;
//
//
//
//
//
//
//    }
}
