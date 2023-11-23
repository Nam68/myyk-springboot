<header>
  <div class="px-3 py-2">
    <div class="d-flex">
      <div id="header-logo">
        <a href="/">
          <img class="korea-flag img-fluid rounded" src="/img/title.jpg"/>
        </a>
      </div>
      <div id="header-btn-set" class="align-self-center pe-3">
        <button type="button" class="btn btn-outline-secondary me-2"><@msg "login.name"/></button>
        <button type="button" class="btn btn-primary" onclick="location.href='/member/tmp/code/create/input'"><@msg "signup.name"/></button>
      </div>
    </div>
  </div>
</header>

<div id="header-icon-holder">
  <div class="row text-center border-bottom">
    <div class="col">
      <a href="#" class="nav-link text-decoration-none">
        <div class="header-icon"><i class="bi bi-image"></i></div>
        <div class="header-item"><@msg "album.name"/></div>
      </a>
    </div>
    <div class="col">
      <a href="#" class="nav-link text-decoration-none">
        <div class="header-icon"><i class="bi bi-calendar-week"></i></div>
        <div class="header-item"><@msg "plan.name"/></div>
      </a>
    </div>
    <div class="col">
      <a href="#" class="nav-link text-decoration-none">
        <div class="header-icon"><i class="bi bi-calculator"></i></div>
        <div class="header-item"><@msg "account.name"/></div>
      </a>
    </div>
    <div class="col">
      <a href="#" class="nav-link text-decoration-none">
        <div class="header-icon"><i class="bi bi-journal-text"></i></div>
        <div class="header-item"><@msg "board.name"/></div>
      </a>
    </div>
  </div>
</div>
