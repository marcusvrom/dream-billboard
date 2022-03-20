import './footer.css';
import { BsFillSuitHeartFill } from 'react-icons/bs'

function Footer() {
    return (
        <footer className="container mt-3 pb-4">
            <div className="row text-center">
                <p>Developed with <BsFillSuitHeartFill /> by <a href="https://github.com/marcusvrom" target="_blank">Marcus Romano</a></p>
            </div>
        </footer>
    )
}

export default Footer;