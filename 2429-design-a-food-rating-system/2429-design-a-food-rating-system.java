class FoodRatings {
    class Pair{
        String food;
        int rating;
        Pair(String _f,int _r){
            food = _f;
            rating = _r;
        }
    }
    Map<String,String> fc;
    Map<String,Integer> fr;
    Map<String,PriorityQueue<Pair>> mp;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        fc = new HashMap<>();
        fr = new HashMap<>();
        mp = new HashMap<>();

        int n = foods.length;

        for(int i=0;i<n;i++){
            fc.put(foods[i],cuisines[i]);
            fr.put(foods[i],ratings[i]);
            mp.putIfAbsent(cuisines[i],new PriorityQueue<>(
                (a,b)->a.rating!=b.rating?b.rating-a.rating:a.food.compareTo(b.food)
            ));
            mp.get(cuisines[i]).add(new Pair(foods[i],ratings[i]));
        }

    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = fc.get(food);
        fr.put(food,newRating);
        mp.get(cuisine).add(new Pair(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = mp.get(cuisine);
        while(true){
            Pair top = pq.peek();
            if(top.rating == fr.get(top.food)) return top.food;
            else pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */