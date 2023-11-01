import { ReactComponent as GithubIcon } from "assets/img/github.svg";
import "./styles.css";

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="dsmovie-nav-content">
          <span className="dsmovie-menu-logo">
            <span className="dsmovie-menu">
              <li>
                <a href="/">
                  <h1 className="home">DSmovie</h1>
                </a>
              </li>
              <li>
                <a href="/admin">Admin</a>
              </li>
            </span>
          </span>
          {/* <a href="https://github.com/Dnuns" target="_blank" rel="noreferrer">
            <div className="dsmovie-contact-container">
              <GithubIcon />
              <p className="dsmovie-contact-link">/Dnuns</p>
            </div>
          </a> */}
          <span className="dsmovie-menu">
            <li>
              <a href="/register">Sign Up</a>
            </li>
            <li>
              <a href="/login">Sign In</a>
            </li>
          </span>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
