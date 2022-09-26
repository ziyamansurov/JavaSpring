package ownspring.controller;

public class TestMain {
    public static void main(String[] args) {
//        System.out.println("Encrypted="+encrypt("Ziya", 1, 19) );
//        String val=encrypt("sagoldwqdqwqd", 213, 19);
//        System.out.println("Encrypted="+encrypt("sagol", 1, 19) );
//
//        System.out.println(val);
//        System.out.println("Decrypted="+ decrypted(val, 1, 19));

        String val=encrypt( "sagol");
        System.out.println(val);


    }

    public static String encrypt(String password ){
        String hashed="";


        for(int i=0;i<password.length();i++){

          String currenthash= String.valueOf(password.charAt(i)+password.hashCode());
          String idk=getEncrypted(currenthash).trim();
          hashed+=idk;


        }


        return hashed;
    }

    public static String getEncrypted(String encrypt){
String encrypted=" ";
        for(int i=0;i<encrypt.length();i++){

            encrypted+=String.valueOf(Character.toChars(90-Integer.parseInt(String.valueOf(encrypt.charAt(i)))));


        }
     //   System.out.println(encrypted);
        return encrypted;

    }

    public static String decrypted(String encrypted,int id,int age){
        String[] arr=encrypted.split(" ");
        String decrypt="";
        for(int i=0;i<arr.length;i++){

            if( getDecrypted(arr[i])!=""){
                  decrypt+=String.valueOf(Character.toChars(Integer.parseInt(  getDecrypted(arr[i])) / (id + age)));

            }
           //
//

        }

        return decrypt;
    }
    public static String getDecrypted(String encrypt){
        String decrypted="";

        for(int i=0;i<encrypt.length();i++){


            decrypted+=String.valueOf(90-encrypt.charAt(i));





        }

        return decrypted;






    }


}
