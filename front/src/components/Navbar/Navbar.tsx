import { Link } from 'react-router-dom';
import './navbar.css'
import { BsPlusLg } from "react-icons/bs";

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="nav-content">
                    <Link to="/">  
                        <h3 className="nav-logo">DreamBillboard</h3>
                    </Link>
                    <Link to="/new/dream">
                        <span className="btn btn-dark d-flex align-items-center"><BsPlusLg /><span className="btn-text">New Dream</span></span>
                    </Link>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;
