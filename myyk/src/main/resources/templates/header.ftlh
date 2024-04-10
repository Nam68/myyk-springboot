<header>
  <div class="px-3 py-2">
    <div class="d-flex">
      <div id="header-logo">
        <a href="/">
          <img src="/img/title.jpg"/>
        </a>
      </div>
      <div id="header-btn-set" class="align-self-center pe-3">
        <#if login_info?has_content>
        <div class="row">
          <div class="col text-end" id="header-nickname-holder">
            <div class="row">${login_info.nickname}</div>
            <div class="row"><@msg "member.type.${login_info.memberType.value}"/></div>
          </div>
          <div class="col flex-shrink-0 dropdown">
            <a class="text-decoration-none dropdown-toggle"id="header-member-holder" href="#" data-bs-toggle="dropdown" aria-expanded="false">
              <img class="rounded-circle" src="${login_info.memberIcon}" alt="member icon">
            </a>
            <ul class="dropdown-menu dropdown-menu-end text-small shadow mt-3">
              <li><a class="dropdown-item" href="#">New project...</a></li>
              <li><a class="dropdown-item" href="#">Settings</a></li>
              <li><a class="dropdown-item" href="#">Profile</a></li>
              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="/login/logout"><@msg "logout.name"/></a></li>
            </ul>
          </div>
        </div>
        <#else>
        <button type="button" class="btn btn-outline-secondary me-2" onclick="location.href='/login/input'"><@msg "login.name"/></button>
        <button type="button" class="btn btn-primary" onclick="location.href='/member/tmp/code/create/input'"><@msg "signup.name"/></button>
        </#if>
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
      <a href="/account" class="nav-link text-decoration-none">
        <div class="header-icon"><i class="bi bi-calculator"></i></div>
        <div class="header-item"><@msg "book.name"/></div>
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
