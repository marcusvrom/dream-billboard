import axios, { AxiosRequestConfig } from 'axios';
import { useState } from 'react';
import { BsCheckCircle } from 'react-icons/bs'
import { useNavigate } from 'react-router-dom';
import { User } from '../../types/user';
import { BASE_URL } from '../../utils/requests';

function DreamForm() {

    const navigate = useNavigate();

    const [user, setUser] = useState<User>({
        id: 0, twitterUser: ""
    })

    const now: Date = new Date();
    console.log(now.toJSON())

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const title = (event.target as any).title.value;
        const details = (event.target as any).details.value;
        const dreamDate = (event.target as any).dreamDate.value;
        const twitterUser = (event.target as any).tt.value;

        let postConfig: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'POST',
            url: '/v1/dreams',
            data: {
                user: null,
                title: title,
                details: details,
                dreamDate: dreamDate
            }
        }

        if(twitterUser) {
            const putConfig: AxiosRequestConfig = {
                baseURL: BASE_URL,
                method: 'PUT',
                url: '/v1/users',
                data: {
                    twitterUser: twitterUser
                }
            }

            axios.get(`${BASE_URL}/v1/users/user/${twitterUser}`)
                .then(response => {
                    const data = response.data;
                    setUser(data);
                })
            
            axios(putConfig).then(res => {})

            postConfig = {
                baseURL: BASE_URL,
                method: 'POST',
                url: '/v1/dreams',
                data: {
                    user: user.id,
                    title: title,
                    details: details,
                    dreamDate: dreamDate
                }
            }
        }

        axios(postConfig).then(res => {
            navigate("/");
        })
        
    }
    

    return (
        <div className="container">
            <div className="row d-flex align-items-center justify-content-center text-center">
                <form className="dream-card" onSubmit={handleSubmit}>
                <h2>What's ur dream?</h2>
                    <div className="mt-2">
                        <label>Dream Title *</label>
                        <input required type="text" maxLength={20} name="title" className="form-control" placeholder="Type what you really want..."/>
                    </div>

                    <div className="mt-2">
                        <label>Dream Details</label>
                        <input type="text" maxLength={255} name="details" className="form-control" placeholder="Type what you really want..."/>
                    </div>

                    <div className="mt-2">
                        <label>Do you want to reach it when? (approximately)</label>
                        <input required type="date" name="dreamDate" className="form-control" min="2022-03-19"/>
                    </div>

                    <div className="mt-2">
                        <label>Twitter User (If empty, user will be anonymous)</label>
                        <input type="text" maxLength={15} name="tt" className="form-control" placeholder="Without '@'"/>
                    </div>

                    <div className="d-flex align-items-center justify-content-center">
                        <button type="submit" className="mt-4 p-3 btn btn-dark d-flex align-items-center">
                            <BsCheckCircle /><span className="btn-text">Send Dream to Billboard</span>
                        </button>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default DreamForm;