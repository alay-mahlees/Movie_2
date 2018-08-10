package com.example.ropot.movie_1.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MovieDetails implements Parcelable {

    /**
     * id : 353081
     * results : [{"id":"5a77b31e925141775c0082c6","iso_639_1":"en","iso_3166_1":"US","key":"wb49-oV0F78","name":"Mission: Impossible - Fallout (2018) - Official Trailer - Paramount Pictures","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5b4f5630c3a368304d014038","iso_639_1":"en","iso_3166_1":"US","key":"XiHiW4N7-bo","name":"Mission: Impossible - Fallout (2018) - Official Trailer - Paramount Pictures","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5b4f56510e0a264b8a0115a6","iso_639_1":"en","iso_3166_1":"US","key":"Z_aCOQi5tm4","name":"Mission: Impossible-Fallout (2018)- \"All Stunts\"- Paramount Pictures","site":"YouTube","size":720,"type":"Clip"},{"id":"5b4f565d0e0a264b90011617","iso_639_1":"en","iso_3166_1":"US","key":"Um0aZKbpe1Y","name":"Mission: Impossible - Fallout (2018) - Helicopter Stunt Behind The Scenes - Paramount Pictures","site":"YouTube","size":1080,"type":"Clip"},{"id":"5b4f566a92514138c800fd35","iso_639_1":"en","iso_3166_1":"US","key":"2BnOebsDtAQ","name":"Mission: Impossible - Fallout (2018) - HALO Jump Stunt Behind The Scenes - Paramount Pictures","site":"YouTube","size":1080,"type":"Clip"},{"id":"5b4f5686c3a368305e011c67","iso_639_1":"en","iso_3166_1":"US","key":"MEOOas3JZt0","name":"Mission Impossible - Fallout | Official International Trailer | Paramount Pictures International","site":"YouTube","size":1080,"type":"Trailer"}]
     */

    private int id;
    private List<ResultsBean> results;

    public MovieDetails(Parcel in) {
        id = in.readInt();
        results = in.readArrayList(MovieDetails.class.getClassLoader());
    }

    public static final Creator<MovieDetails> CREATOR = new Creator<MovieDetails>() {
        @Override
        public MovieDetails createFromParcel(Parcel in) {
            return new MovieDetails(in);
        }

        @Override
        public MovieDetails[] newArray(int size) {
            return new MovieDetails[size];
        }
    };

    public MovieDetails() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeList(results);
    }

    public static class ResultsBean {
        /**
         * id : 5a77b31e925141775c0082c6
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : wb49-oV0F78
         * name : Mission: Impossible - Fallout (2018) - Official Trailer - Paramount Pictures
         * site : YouTube
         * size : 1080
         * type : Trailer
         */

        private String id;
        private String iso_639_1;
        private String iso_3166_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
