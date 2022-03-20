import { Link } from 'react-router-dom';
import './dreamCard.css';
import { BsHeart } from 'react-icons/bs'
import { BsHeartFill } from 'react-icons/bs'
import { Dream } from '../../types/dream';

type Props = {
    dream: Dream;
}

function DreamCard( { dream } : Props) {

    /*const dream = {
        user: {
            id: 1,
            twitterUser: null
        },
        likes: 0,
        title: "Test Title",
        details: "Details Test",
        dreamDate: "2022-05-06",
        postDate: "2022-03-19 00:00:00"
    }*/

    /*
    <button className="like-button">
                    <BsHeart /> 
                    <span className="like-count">{dream.likes}</span>
                </button>
    */

    return (
        <div className="dream-card mb-4">
            <div className="row d-flex align-items-center justify-content-center">
                <h3 className="dream-title">{dream.title}</h3>
                <p className="mt-2 mb-2">Target until: {dream.dreamDate}</p>
                <p className="mb-0">
                    By: 
                    {dream.user.twitterUser != "" ? <a href={`https://twitter.com/${dream.user.twitterUser}`} target="_blank"> @{dream.user.twitterUser}</a> : <span> Anonymous</span>}
                    </p>
                <span className="d-flex align-items-center justify-content-between">
                    {dream.postDate}
                    <Link to={`/dream/${dream.id}`}>
                        <span className="btn btn-secondary text-link">See more...</span>
                    </Link>
                </span>
                
            </div>
        </div>
    );
}

export default DreamCard;