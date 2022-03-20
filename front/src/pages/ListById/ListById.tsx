import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Dream } from "../../types/dream";
import { User } from "../../types/user";
import { BASE_URL } from "../../utils/requests";
import { BsHeart } from 'react-icons/bs'
import { BsHeartFill } from 'react-icons/bs'

import './listById.css'

function ListById() {

    const params = useParams()

    const [dream, setDream] = useState<Dream>({
        id: 0,
        user: {
            id: 0, 
            twitterUser: ""
        },
        likes: 0,
        title: "",
        details: "",
        dreamDate: "",
        postDate: ""
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/v1/dreams/${params.dreamId}`)
            .then(res => {
                const dream = res.data as Dream;
                if(!dream.user) {
                    dream.user = {id: 0, twitterUser: ""} as User;
                }
                setDream(dream);
        })
    }, []);

    /*
    <button className="like-button">
                            <BsHeart /> 
                            <span className="like-count">{dream.likes}</span>
                        </button>
    */

    return (
        <div className="container">
            <div className="row">
                <div className="dream-card d-flex justify-content-center flex-column">
                    <div className="card-header pb-0 pt-0 d-flex align-items-center justify-content-start">
                        <p>{dream.postDate}</p>
                    </div>
                    <div className="card-title">
                        <p className="mt-2 mb-2">Target until: {dream.dreamDate}</p>
                        <h1 className="mb-0">{dream.title}</h1>
                    </div>
                    <div className="card-body pt-1">
                        <p className="mb-1">{dream.details}</p>
                        <p>Posted by: {dream.user.twitterUser != "" ? <a href={`https://twitter.com/${dream.user.twitterUser}`} target="_blank"> @{dream.user.twitterUser}</a> : <span>Anonymous</span>}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ListById;