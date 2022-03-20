import axios from "axios";
import { useEffect, useState } from "react";
import DreamCard from "../../components/DreamCard/DreamCard";
import { DreamPage } from "../../types/dream";
import { User } from "../../types/user";
import { BASE_URL } from "../../utils/requests";
import { BsCheckCircle } from 'react-icons/bs'

import './listing.css';

function Listing() {

    const [pageNumber, setPageNumber] = useState(0)

    const [page, setPage] = useState<DreamPage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/v1/dreams?size=12&page=${pageNumber}`)
            .then(res => {
                const data = res.data as DreamPage;
                console.log(data);
                setPage(data);
            })
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    const handleFilterPage = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let numberPage = (event.target as any).pageFilter.value;
        numberPage = numberPage - 1;
        setPageNumber(numberPage);
    }
    return (
        <div className="container">
            
            <div className="w-100 d-flex justify-content-between">
                <span onClick={() => handlePageChange(page.number - 1)} className={page.first ? 'btn-page mb-3 disabled' : 'btn-page mb-3'}>Previous Page</span>
                <p>{page.number + 1} of {page.totalPages}</p>
                <span onClick={() => page.last ? null : handlePageChange(page.number + 1)} className={page.last ? 'btn-page mb-3 disabled' : 'btn-page mb-3'}>Next Page</span>
            </div>
            <div className="row">

                {page.content.map(dream => {
                    if(!dream.user){
                        dream.user = {id: 0, twitterUser: ""} as User;
                    } 
                    return(
                        <div key={dream.id} className="col-12 col-md-6 col-lg-4">
                            <DreamCard dream={dream}></DreamCard>
                        </div>
                    )
                    }
                )}

                

            </div>
            <div className="row">
                <form className="d-flex align-items-center justify-content-end" onSubmit={handleFilterPage}>
                    <div>
                        <label>Filter Specific Page</label>
                        <div className="d-flex justify-content-end">
                            <input type="number" name="pageFilter" max={page.totalPages} min={1} className="form-control filter-number" />
                            <button type="submit" className="d-flex align-items-center btn btn-dark btn-filter-number"><BsCheckCircle /></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Listing;