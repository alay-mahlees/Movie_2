package com.example.ropot.movie_1.Models;

import java.util.List;

public class MovieReviews {
    /**
     * id : 353081
     * page : 1
     * results : [{"author":"TopKek","content":"Some things age like fine wine and in the cinematic world the \u2018Mission: Impossible\u2019 franchise is a great example of the adage. Perhaps it has to do with the 56-year-old Tom Cruise who defies age and pushes his physical boundaries for our viewing pleasure? The answer is quite evident in \u2018Fallout\u2019 as his Ethan Hunt is as good as a caped superhero in the sixth film of the series. The story isn't all that new with its twists and turns. But \u2018Fallout\u2019 manages to build on the previous films in the series by bringing back old friends and foes, besides adding some new ones. Henry Cavill as August Walker fits right into this universe as the hammer to the scalpel that is Ethan Hunt. His presence is looming enough to fill the entire screen whenever he appears. Simon Pegg takes on the status of a series regular alongside Ving Rhames, whose Benji and Luther respectively play more than just mere sidekicks as they add comic levity and heart. Alec Baldwin and Angela Bassett also make a mark in their brief appearances but watch out for impactful turns by Rebecca Ferguson and Michelle Monaghan along the way.\r\n\r\nWriter & Director Christopher McQuarrie allows each character to shine while building on their history with each other, thus making them endearing to the audience. This only serves to up the ante when they\u2019re in danger. McQuarrie also lets the story breathe by bringing some calm before the storm hits. Which leads to the most crucial aspect of the series, and one that McQuarrie clearly excels at in this film \u2013 the action sequences. Not only are they meticulously planned; they are executed with precision, even when the fist fights are gritty and gruesome. Rob Hardy beautifully choreographs the camerawork following these intricate set-pieces, either allowing you to take in the expanse or bringing you up close and personal when required. This is paired with a soundtrack by Lorne Balfe that lends to the tension by giving the iconic \u2018Mission Impossible\u2019 theme a sinister sense of urgency.\r\n\r\nMcQuarrie has now directed two \u2018Mission: Impossible\u2019 films; his understanding of the franchise and its characters proves to be the secret weapon of the series. The fact that the stunts are largely done with practical effects featuring the cast, and most prominently Cruise himself, sets a whole new standard for action films. \u2018Mission: Impossible \u2013 Fallout\u2019 is a great mix of plot, pacing and performances that is undeniably the best entry in the franchise, while it re-establishes Cruise\u2019s status as an action superstar.\r\n\r\nReview by Times of India (TOI)\r\nFinal Rating - 4.0/5","id":"5b5b3d24c3a368670c015b12","url":"https://www.themoviedb.org/review/5b5b3d24c3a368670c015b12"},{"author":"DanDare","content":"Mission Impossible - Fallout is a continuation of Mission Impossible - Rogue Nation. It is directed by Christopher McQuarrie who also directed Rogue Nation and also has the return of the psycho villain Solomon Lane (Sean Harris) who the bad guys want to set free.\r\n\r\nEthan Hunt (Tom Cruise) is after the mysterious John Lark and a terrorist group called the Apostles who have stolen three plutonium grade devices and plan to set them off.\r\n\r\nHunt has to reluctantly accept a new team member. CIA operative August Walker (Henry Cavill) because the IMF team were responsible for losing the plutonium in Berlin.\r\n\r\nAs a spy thriller there is enough tension, thrills and a serpentine story with several twists.\r\n\r\nHowever the film is overlong and I felt that some of the action scenes consisted of myriad chase scenes that were stylishly done but nothing really memorable liked the Burj Khalifa climbing scene.","id":"5b5bb15dc3a368421b00811d","url":"https://www.themoviedb.org/review/5b5bb15dc3a368421b00811d"}]
     * total_pages : 1
     * total_results : 2
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * author : TopKek
         * content : Some things age like fine wine and in the cinematic world the ‘Mission: Impossible’ franchise is a great example of the adage. Perhaps it has to do with the 56-year-old Tom Cruise who defies age and pushes his physical boundaries for our viewing pleasure? The answer is quite evident in ‘Fallout’ as his Ethan Hunt is as good as a caped superhero in the sixth film of the series. The story isn't all that new with its twists and turns. But ‘Fallout’ manages to build on the previous films in the series by bringing back old friends and foes, besides adding some new ones. Henry Cavill as August Walker fits right into this universe as the hammer to the scalpel that is Ethan Hunt. His presence is looming enough to fill the entire screen whenever he appears. Simon Pegg takes on the status of a series regular alongside Ving Rhames, whose Benji and Luther respectively play more than just mere sidekicks as they add comic levity and heart. Alec Baldwin and Angela Bassett also make a mark in their brief appearances but watch out for impactful turns by Rebecca Ferguson and Michelle Monaghan along the way.

         Writer & Director Christopher McQuarrie allows each character to shine while building on their history with each other, thus making them endearing to the audience. This only serves to up the ante when they’re in danger. McQuarrie also lets the story breathe by bringing some calm before the storm hits. Which leads to the most crucial aspect of the series, and one that McQuarrie clearly excels at in this film – the action sequences. Not only are they meticulously planned; they are executed with precision, even when the fist fights are gritty and gruesome. Rob Hardy beautifully choreographs the camerawork following these intricate set-pieces, either allowing you to take in the expanse or bringing you up close and personal when required. This is paired with a soundtrack by Lorne Balfe that lends to the tension by giving the iconic ‘Mission Impossible’ theme a sinister sense of urgency.

         McQuarrie has now directed two ‘Mission: Impossible’ films; his understanding of the franchise and its characters proves to be the secret weapon of the series. The fact that the stunts are largely done with practical effects featuring the cast, and most prominently Cruise himself, sets a whole new standard for action films. ‘Mission: Impossible – Fallout’ is a great mix of plot, pacing and performances that is undeniably the best entry in the franchise, while it re-establishes Cruise’s status as an action superstar.

         Review by Times of India (TOI)
         Final Rating - 4.0/5
         * id : 5b5b3d24c3a368670c015b12
         * url : https://www.themoviedb.org/review/5b5b3d24c3a368670c015b12
         */

        private String author;
        private String content;
        private String id;
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
