package com.train.easycoding;

/**
 * List<? extend T> List<? supper T>
 */
public class ExtendSupperTest {


    /*public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<RedCat> redCats = new ArrayList<>();
        animals.add(new Animal());
        cats.add(new Cat());
        cats.add(new RedCat());

        List<? extends Cat> extendCatFromAnimal = animals;
        List<? super Cat> supperCatFromAnimal = animals;

        *//**
         * ？extends T : 不能add.
         *  只能取T及T的父类
         *//*
        extendCatFromAnimal.add(new Animal());
        extendCatFromAnimal.add(new Cat());
        extendCatFromAnimal.add(new RedCat());
        Animal animal = extendCatFromAnimal.get(0);
        Cat cat = extendCatFromAnimal.get(0);
        RedCat redCat = extendCatFromAnimal.get(0);


        *//**
         * <? supper T>
         * 只能添加T或T的子类** supper;
         * 不能get();
         *//*
        supperCatFromAnimal.add(new Animal());
        supperCatFromAnimal.add(new Cat());
        supperCatFromAnimal.add(new RedCat());
        Animal supperAnimal = supperCatFromAnimal.get(0);
        Cat supperCat = supperCatFromAnimal.get(0);
        RedCat supperRedCat = supperCatFromAnimal.get(0);


        List<? extends Cat> extendCatFromcat = cats;
        List<? super Cat> superCatFromcat = cats;

        List<? extends Cat> extendCatFromRedcat = redCats;
        List<? super Cat> superCatFromRedcat = redCats;
        extendCatFromRedcat.add(new Cat());
        superCatFromRedcat.add(new Cat());
    }
*/
}

class Animal {

}

class Cat extends Animal {

}

class RedCat extends Cat {

}
